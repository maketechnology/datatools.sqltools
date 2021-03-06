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
package org.eclipse.datatools.sqltools.db.derby.parser;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.datatools.sqltools.sql.parser.ParsingResult;
import org.eclipse.datatools.sqltools.sql.parser.Token;
import org.eclipse.datatools.sqltools.sql.parser.ast.IASTDeployable;
import org.eclipse.datatools.sqltools.sql.parser.ast.IASTSQLParam;
import org.eclipse.datatools.sqltools.sql.parser.ast.IASTSQLParamDefList;
import org.eclipse.datatools.sqltools.sql.parser.ast.IASTSQLStatement;
import org.eclipse.datatools.sqltools.sql.parser.ast.IASTStart;
import org.eclipse.datatools.sqltools.sql.parser.ast.Node;
import org.eclipse.datatools.sqltools.sql.parser.ast.SimpleNode;
import org.eclipse.jface.text.IDocument;

/**
 * @author Hui Cao
 * 
 */
public class DerbyParsingResult extends ParsingResult {
	
    /**
     *  
     */
    public DerbyParsingResult()
    {
    }
    
	
	/**
     * @param rootNode
     * @param exceptions
     */
    public DerbyParsingResult(Node rootNode, ArrayList exceptions)
    {
        super(rootNode, exceptions);
    }


	protected ArrayList findCursorNames(IDocument document, int offset,
			SimpleNode node) {
        ArrayList cursors = new ArrayList();
        if ("DECLARE".equalsIgnoreCase(node.getFirstToken().image))
        {

            try
            {
                Token second = node.getFirstToken().next;
                Token third = second.next;
                if ("CURSOR".equalsIgnoreCase(third.image))
                {
                    cursors.add(second.image);
                }
            }
            catch (RuntimeException e)
            {
                //maybe there's no second and third token, do nothing
            }
        }
        //we must use recursion since cursors defined in a compound statement can be referenced by later statements
        else if ((node instanceof IASTStart || node instanceof IASTDeployable || node instanceof IASTSQLStatement)
        && node.jjtGetNumChildren() > 0)
        {
            for (int i = 0; i < node.jjtGetNumChildren(); i++)
            {
                SimpleNode child = (SimpleNode) node.jjtGetChild(i);
                if (child.getStartOffset(document) >= offset)
                {
                    break;
                }
                cursors.addAll(findCursorNames(document, offset, child));

            }
        }
        return cursors;
    }

	protected HashMap findVariables(IDocument document, int offset,
			SimpleNode node) {
        HashMap map = new HashMap();
        if (node instanceof IASTSQLParam && !(node.jjtGetParent() instanceof IASTSQLParamDefList))
        {
            IASTSQLParam param = (IASTSQLParam) node;
            map.put(param.getName(), param);
        }
        //we must use recursion since cursors defined in a compound statement can be referenced by later statements
        else if ((node instanceof IASTStart || node instanceof IASTDeployable || node instanceof IASTSQLStatement)
        && node.jjtGetNumChildren() > 0)
        {
            for (int i = 0; i < node.jjtGetNumChildren(); i++)
            {
                SimpleNode child = (SimpleNode) node.jjtGetChild(i);
                if (child.getStartOffset(document) >= offset)
                {
                    break;
                }
                map.putAll(findVariables(document, offset, child));

            }
        }
        return map;
	}

	protected HashMap findCursors(IDocument document, int offset,
			SimpleNode node) {
		return new HashMap();
	}

	public boolean isValidObjectsFormats(ArrayList tokenLists) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isVarOrPara(ArrayList tokenLists) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList getPrefix(ArrayList tokenLists, Node node) {
		return new ArrayList();
	}

	public ArrayList getUnSharableTempTables(IDocument document, int offset) {
		return new ArrayList();
	}

}
