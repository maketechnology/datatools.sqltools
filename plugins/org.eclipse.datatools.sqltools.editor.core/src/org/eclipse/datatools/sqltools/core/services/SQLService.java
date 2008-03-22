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

package org.eclipse.datatools.sqltools.core.services;

import java.util.ArrayList;

import org.eclipse.datatools.connectivity.sqm.core.definition.DatabaseDefinition;
import org.eclipse.datatools.modelbase.sql.schema.SQLObject;
import org.eclipse.datatools.sqltools.core.EditorCorePlugin;
import org.eclipse.datatools.sqltools.editor.template.GenericSQLContextType;
import org.eclipse.datatools.sqltools.internal.core.Messages;
import org.eclipse.datatools.sqltools.sql.ISQLSyntax;
import org.eclipse.datatools.sqltools.sql.identifier.IIdentifierValidator;
import org.eclipse.datatools.sqltools.sql.parser.ParserParameters;
import org.eclipse.datatools.sqltools.sql.parser.ParserProposalAdvisor;
import org.eclipse.datatools.sqltools.sql.parser.ParsingResult;
import org.eclipse.datatools.sqltools.sql.parser.SQLParser;
import org.eclipse.datatools.sqltools.sql.parser.ast.IASTSQLDelimiter;
import org.eclipse.datatools.sqltools.sql.parser.ast.IASTSQLStatementElement;
import org.eclipse.datatools.sqltools.sql.parser.ast.IASTStart;
import org.eclipse.datatools.sqltools.sql.parser.ast.Node;
import org.eclipse.datatools.sqltools.sql.updater.ProceduralObjectSourceUpdater;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.osgi.util.NLS;


/**
 * A SQL language related service specific to a database definition.
 * @author Hui Cao
 *
 */
public class SQLService
{
    /**
     * Returns an <code>ISQLSyntax</code> object which can be used to highlight sql statements in SQL editor.
     * 
     * @return an <code>ISQLSyntax</code> object specific to a SQL dialect.
     */
    public ISQLSyntax getSQLSyntax()
    {
        return null;
    }

    /**
     * Returns a specific <code>GenericSQLContextType</code> object which identifies the context type of templates
     * used in SQL editor.
     * 
     * @return a <code>GenericSQLContextType</code> object
     */
    public GenericSQLContextType getSQLContextType()
    {
        // TODO Auto-generated method stub
        return new GenericSQLContextType();
    }

    /**
     * Returns a <code>SQLParser</code> object which is used to parse SQL dialect.
     * 
     * @return a <code>SQLParser</code> object
     */
    public SQLParser getSQLParser()
    {
        return null;
    }

    /**
     * Splits the sql statement into groups of statements according to SQL statement delimiter such as "go" or ";".
     * 
     * @param sql statement to be splitted
     * @return sql statement array
     */
	public String[] splitSQL(String sql) {
		SQLParser parser = getSQLParser();
		if (parser == null)
		{
			return new String[]{sql};
		}
	    ArrayList groups = new ArrayList();
	    try
	    {
	        IDocument doc = new Document(sql);
	        ParserParameters parserParameters = new ParserParameters(true);
	        parserParameters.setProperty(ParserParameters.PARAM_CONSUME_EXCEPTION, Boolean.FALSE);
			ParsingResult result = parser.parse(sql, parserParameters);
	        
            if (result.getExceptions() != null && !result.getExceptions().isEmpty())
            {
                return splitSQLByTerminatorLine(sql, parser.getStatementTerminators());
            }

	        IASTStart root = result.getRootNode();
	        root.setDocument(doc);
	        String group = "";
	        if (root.jjtGetNumChildren() > 0)
	        {
                for (int i = 0; i < root.jjtGetNumChildren(); i++)
                {
                    Node node = root.jjtGetChild(i);
                    if (node instanceof IASTSQLDelimiter)
                    {
                        //trim() will remove ascii control characters as well
                        if (!group.trim().equals(""))
                        {
                            groups.add(group);
                            group = "";
                        }
                    }
                    else if (node instanceof IASTSQLStatementElement)
                    {
                        group += node.getSQLText() + " ";
                    }
                    else
                    {
                        group += node.getSQLText() + System.getProperty("line.separator");

                    }
                }
	        }
	        else
	        {
	            group = sql;
	        }
            if (!group.trim().equals(""))
            {
                groups.add(group);
            }
	
	    }
	    catch (Exception e1)
	    {
	        EditorCorePlugin.getDefault().log(NLS.bind(Messages.DefaultSQLSyntax_exception_splitSQL, sql), e1);
	    }
	    return (String[]) groups.toArray(new String[groups.size()]);
	}
	
	/**
	 * Splits SQL statements on any ";" characters and stand-alone "GO".
	 */
	public String[] splitSQLByTerminatorLine(String sql, String[] terminators)
	{
		IDocument doc = new Document(sql);
		ArrayList groups = new ArrayList();
		//the start position for current group
		int index = 0;
		int numberOfLines = doc.getNumberOfLines();
		try {
			for (int i = 0; i < numberOfLines; i++) {
				IRegion r = doc.getLineInformation(i);
				String line = doc.get(r.getOffset(), r.getLength());
				for (int j = 0; j < terminators.length; j++) {
					if (line.trim().equalsIgnoreCase(terminators[j])) {
						String string = doc.get(index, r.getOffset() - index);
						if (string.trim().length() > 0) {
							groups.add(string);
						}
						index = r.getOffset() + doc.getLineLength(i);
						break;
					}
					else if (line.indexOf(";")>=0)
					{
						String string = doc.get(index, r.getOffset() + line.indexOf(";") - index);
						if (string.trim().length() > 0) {
							groups.add(string);
						}
						index = r.getOffset() + line.indexOf(";") + 1;
						break;
					}
				}
			}
			if (index < doc.getLength() - 1) {
				String string = doc.get(index, doc.getLength() - index);
				if (string.trim().length() > 0) {
					groups.add(string);
				}
			}
		} catch (Exception e) {
			//parse error, simply return
			return new String[]{sql};
		}
		return (String[]) groups.toArray(new String[groups.size()]);
	}
	
	public ParserProposalAdvisor getParserProposalAdvisor()
	{
		return new ParserProposalAdvisor();
	}

    /**
     * Returns Identifier Validator
     * TODO implement IIdentifierValidator
     * @return
     */
    public IIdentifierValidator getIdentifierValidator()
    {
    	return null;
    }
    
    /**
     * Returns the ProceduralObjectSourceUpdater object used to update the source of the given sql object 
     * @return
     */
    public ProceduralObjectSourceUpdater getProceduralObjectSourceUpdater(SQLObject object, DatabaseDefinition dbDefinition)
    {
        return null;
    }
}
