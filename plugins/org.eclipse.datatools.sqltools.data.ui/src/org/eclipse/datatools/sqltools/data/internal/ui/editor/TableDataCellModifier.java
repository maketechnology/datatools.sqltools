/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.sqltools.data.internal.ui.editor;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.datatools.modelbase.sql.tables.Column;
import org.eclipse.datatools.sqltools.data.internal.core.common.IColumnDataAccessor;
import org.eclipse.datatools.sqltools.data.internal.core.editor.IRowData;
import org.eclipse.datatools.sqltools.data.internal.core.editor.ITableData;
import org.eclipse.datatools.sqltools.data.internal.ui.DataUIPlugin;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Item;

public class TableDataCellModifier implements ICellModifier {

    protected static final int MAX_LENGTH = 1000;
    
    protected TableDataEditor editor;
    protected TableViewer viewer;
    
    protected boolean canModify = false;
    
    public TableDataCellModifier(TableDataEditor editor, TableViewer viewer)
    {
        this.editor = editor;
        this.viewer = viewer;
    }
    
    public boolean canModify(Object element, String property) {
    	
    	if (!canModify)
    		return false;
    	
    	if (editor.isReadonly())
    		return false;
    	
    	int col = getColumnIndex(property);    	
    	
    	// can not modify columns generated-always by database
    	if (isColumnGenerated(col)) {
    		return false;
    	}
    	
    	ITableData tableData = editor.getTableData();
    	if (element instanceof IRowData) {
	    	Object val = ((IRowData)element).getValue(col);
	    	int type = tableData.getColumnType(col);
	    	IColumnDataAccessor acc = tableData.getColumnDataAccessor(col);
	    	if (!acc.supportsInlineEdit() || acc.isSnippet(val, type))
	    	    return false;
	    	String s = acc.serialize(val, type);
	    	if (s!=null && s.length()>MAX_LENGTH)
	    		return false;    	
    	}
    	
    	return true;
    }
    
    /**
     * Determines whether or not a particular column is generated-always
     * @param colIndex the column index
     * @return true if a column is generated, false if not
     */
    protected boolean isColumnGenerated(int colIndex)
    {
    	Column sqlCol = (Column) editor.getSqlTable().getColumns().get(colIndex);    	
    	return (sqlCol.getIdentitySpecifier() != null);
    }
    
    public void setCanModify(boolean canModify)
    {
        this.canModify = canModify;
    }

    public Object getValue(Object element, String property) {
        int col = getColumnIndex(property);
        
        if (!(element instanceof IRowData))
            return ""; //$NON-NLS-1$
        
        IRowData row = (IRowData)element;

        try {            
            Object o = row.getValue(col);
            String s = row.getTable().getColumnDataAccessor(col).serialize(o, row.getTable().getColumnType(col));
            
            return (s==null)?"":s; //$NON-NLS-1$
        } catch (Exception ex) {
            DataUIPlugin.getDefault().writeLog(IStatus.ERROR, 0, ex.getMessage(), ex);
            return Messages.getString("TableDataCellModifier.error"); //$NON-NLS-1$
        }
    }

    public void modify(Object element, String property, Object value) {
        int column = getColumnIndex(property);        
        
        if (element instanceof Item)
            element = ((Item) element).getData();
        
        IRowData row = editor.getOrCreateRow();
        
        Object oldObject = row.getValue(column);
        String oldString = row.getTable().getColumnDataAccessor(column).serialize(oldObject, row.getTable().getColumnType(column));
        if (value.equals(oldString))
            return;               
        
        try {
            editor.setDirty(true);
            Object o = row.getTable().getColumnDataAccessor(column).deserialize((String)value, row.getTable().getColumnType(column));
            row.updateValue(column, o);
        }  catch (Exception ex) {            
            IStatus warning = new Status(IStatus.ERROR, DataUIPlugin.PLUGIN_ID, 1, Messages.getString("TableDataCellModifier.dataFormatError"), ex); //$NON-NLS-1$
            ErrorDialog.openError(viewer.getControl().getShell(), Messages.getString("TableDataCellModifier.ErrorUpdatingData"), null, warning); //$NON-NLS-1$
        }
    
        viewer.refresh(row);
    }
    
    protected int getColumnIndex(String property) {
        Object[] properties = viewer.getColumnProperties();
        int col=0;
        while (properties[col]!=property && col<properties.length)
            ++col;
        if (col==properties.length)
            return -1;
        else 
            return col;
    }
    

}
