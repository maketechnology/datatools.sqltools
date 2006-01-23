/*******************************************************************************
 * Copyright (c) 2005 Sybase, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sybase, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.sqltools.plan.internal.ui.actions;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.datatools.sqltools.plan.PlanRequest;
import org.eclipse.datatools.sqltools.plan.internal.Constants;
import org.eclipse.datatools.sqltools.plan.internal.IPlanInstance;
import org.eclipse.datatools.sqltools.plan.internal.PlanViewPlugin;
import org.eclipse.datatools.sqltools.plan.internal.util.ILogger;
import org.eclipse.datatools.sqltools.plan.internal.util.Images;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Loads saved plans.
 * <p>
 * The file should conform to the following DTD constraint.
 * <pre>
 * <?xml version="1.0" encoding="UTF-8"?>
 * <!ELEMENT plans(plan)*>
 * <!ELEMENT plan(request,rawPlan)>
 * <!ELEMENT request(#PCDATA)>
 * <!ELEMENT rawPlan(#PCDATA)>
 * <!ATTLIST plan status CDATA #required type CDATA #required>
 * <!ATTLIST request dbDefinitionId CDATA #required>
 * </pre>
 * 
 * @author Hui Cao
 *  
 */
public class LoadPlanAction extends Action
{
    private static ILogger _log = PlanViewPlugin.getLogger(null);

    /**
     * Constructor
     *
     */
    public LoadPlanAction()
    {
        setText(Messages.getString("LoadPlanAction.title")); //$NON-NLS-1$
        setToolTipText(Messages.getString("LoadPlanAction.tooltip")); //$NON-NLS-1$
        this.setImageDescriptor(Images.DESC_IMPORT_PLAN);
        this.setDisabledImageDescriptor(Images.DESC_IMPORT_PLAN_DISABLE);
    }

    public void run()
    {
        FileDialog dlg = new FileDialog(PlanViewPlugin.getActiveWorkbenchShell(), SWT.OPEN);
        String file = dlg.open();
        if (file != null)
        {
            File f = new File(file);
            if (!f.exists())
            {
                MessageDialog
                        .openInformation(PlanViewPlugin.getActiveWorkbenchShell(), Messages.getString("LoadPlanAction.info"), Messages.getString("LoadPlanAction.filenotfound")); //$NON-NLS-1$ //$NON-NLS-2$
                return;
            }
            try
            {
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document = builder.parse(file);
                NodeList list = document.getDocumentElement().getChildNodes();
                int nodeCount = list.getLength();
                for (int i = 0; i < nodeCount; i++)
                {
                    Node planNode = list.item(i);
                    PlanRequest request = null;
                    NamedNodeMap map = planNode.getAttributes();
                    Node status = map.getNamedItem("status");
                    if (status == null)
                    {
                        continue;
                    }
                    Node type = map.getNamedItem("type");
                    if (type == null)
                    {
                        continue;
                    }
                    NodeList planNodeList = planNode.getChildNodes();
                    for (int j = 0; j < planNodeList.getLength(); j++)
                    {
                        Node subNode = planNodeList.item(j);
                        if (subNode.getNodeName().equals("request"))
                        {
                            NamedNodeMap subNodeAttrs = subNode.getAttributes();
                            Node dbId = subNodeAttrs.getNamedItem("dbDefinitionId");
                            String dbDefinitionId = "";
                            String sql = "";
                            if (dbId == null)
                            {
                                dbDefinitionId = Messages.getString("LoadPlanAction.unknown.db"); //$NON-NLS-1$
                            }
                            else
                            {
                                dbDefinitionId = dbId.getNodeValue();
                            }
                            if (subNode.getFirstChild() != null)
                            {
                                CDATASection sqlCDATA = (CDATASection) subNode.getFirstChild();
                                sql = sqlCDATA.getNodeValue();
                            }
                            request = new PlanRequest(sql, dbDefinitionId, getTypeId(type.getNodeValue()),
                                    PlanRequest.VIEW_ACTIVATE);
                        }
                        else if (subNode.getNodeName().equals("rawPlan"))
                        {
                            String rawPlan = "";
                            if (subNode.getFirstChild() != null)
                            {
                                CDATASection rawPlanCDATA = (CDATASection) subNode.getFirstChild();
                                rawPlan = rawPlanCDATA.getNodeValue();
                            }
                            if (request != null)
                            {
                                IPlanInstance instance = PlanViewPlugin.getPlanManager().createNewPlanInstance(request);
                                if (getStatus(status.getNodeValue()) == IPlanInstance.SUCCESS)
                                {
                                    instance.finishSuccess(rawPlan);
                                }
                                else
                                {
                                    instance.finishFail(new Throwable(rawPlan));
                                }
                            }
                        }
                    }
                }
            }
            catch (Exception e)
            {
                final IStatus fstatus = new Status(IStatus.ERROR, Constants.PLUGIN_ID, IStatus.OK, e.getMessage(), e);
                final String title = Messages.getString("LoadPlanAction.error"); //$NON-NLS-1$
                final String msg = Messages.getString("LoadPlanAction.errorinfo"); //$NON-NLS-1$
                Display display = PlanViewPlugin.getActiveWorkbenchShell().getDisplay();
                display.asyncExec(new Runnable()
                {
                    public void run()
                    {
                        ErrorDialog.openError(PlanViewPlugin.getActiveWorkbenchShell(), title, msg, fstatus);
                    }
                });

                _log.error("LoadPlanAction.error.message", e); //$NON-NLS-1$
            }
        }
    }

    private int getStatus(String desc)
    {
        if ("SUCCESS".equals(desc))
        {
            return IPlanInstance.SUCCESS;
        }
        else if ("SUCCESS".equals(desc))
        {
            return IPlanInstance.FAILED;
        }
        else
        {
            return IPlanInstance.RUNNING;
        }
    }

    private int getTypeId(String desc)
    {
        if (desc.equals("GRAPHIC_PLAN"))
        {
            return PlanRequest.GRAPHIC_PLAN;
        }
        if (desc.equals("TEXT_PLAN"))
        {
            return PlanRequest.TEXT_PLAN;
        }
        return PlanRequest.TEXT_PLAN;
    }
}