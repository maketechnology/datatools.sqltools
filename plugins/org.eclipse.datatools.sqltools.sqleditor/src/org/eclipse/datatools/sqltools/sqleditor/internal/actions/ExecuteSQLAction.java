/*******************************************************************************
 * Copyright (c) 2004, 2005 Sybase, Inc. and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sybase, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.sqltools.sqleditor.internal.actions;

import org.eclipse.datatools.sqltools.core.DatabaseIdentifier;
import org.eclipse.datatools.sqltools.sqleditor.ISQLEditorActionConstants;
import org.eclipse.datatools.sqltools.sqleditor.SQLEditor;
import org.eclipse.datatools.sqltools.sqleditor.internal.IHelpContextIds;
import org.eclipse.datatools.sqltools.sqleditor.internal.SQLEditorResources;
import org.eclipse.ui.PlatformUI;

/**
 * @author Hui Cao
 *  
 */
public class ExecuteSQLAction extends BaseExecuteAction
{
    protected SQLEditor _sqlEditor;

    /**
     * @param text
     * @param image
     */
    public ExecuteSQLAction(SQLEditor targetEditor)
    {
        setText(Messages.getString("ExecuteSQLAction.label"));//$NON-NLS-1$
        setToolTipText(Messages.getString("ExecuteSQLAction.tooltip"));//$NON-NLS-1$
        setImageDescriptor(SQLEditorResources.getImageDescriptor("execute"));
        setActionDefinitionId(ISQLEditorActionConstants.EXECUTE_SQL_ACTION_ID);
        //no need to set image
        setActiveEditor(targetEditor);
        update();

        PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IHelpContextIds.EXECUTE_ALL_ACTION);
    }

    public void setActiveEditor(SQLEditor targetEditor)
    {
        _sqlEditor = targetEditor;
    }

    public void run()
    {
        super.run();
        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(_sqlEditor);
    }

    public void update()
    {
        setEnabled(_sqlEditor != null && _sqlEditor.getConnectionInfo().getSharedConnection() != null);
    }

    public DatabaseIdentifier getDatabaseIdentifier()
    {
    	if (_sqlEditor != null)
    	{
    		String profileName = _sqlEditor.getConnectionInfo().getConnectionProfileName();
    		String dbName = _sqlEditor.getConnectionInfo().getDatabaseName();
    		return new DatabaseIdentifier(profileName, dbName);
    	}
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sybase.stf.dmp.ui.actions.BaseExplainAction#getSQLStatements()
     */
    public String getSQLStatements()
    {
        return _sqlEditor == null ? null : _sqlEditor.getText();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sybase.stf.dmp.ui.actions.BaseExplainAction#getPostRun()
     */
    public Runnable getPostRun()
    {
        Runnable postRun = new Runnable()
        {
            public void run()
            {
            	PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(_sqlEditor);
            }
        }
        ;
        return postRun;
    }

    protected SQLEditor getEditor()
    {
        return _sqlEditor;
    }
}
