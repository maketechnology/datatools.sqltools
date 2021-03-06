/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.sqltools.parsers.sql.query;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author ckadner
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SQLQueryParserMessages
{
    private static final String         BUNDLE_NAME     = "org.eclipse.datatools.sqltools.parsers.sql.query.sqlqueryparsermessages"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
                                                                        .getBundle(BUNDLE_NAME);

    private SQLQueryParserMessages()
    {
    }

    public static String getString(String key)
    {
        try
        {
            return RESOURCE_BUNDLE.getString(key);
        }
        catch (MissingResourceException e)
        {
            return '!' + key + '!';
        }
    }
    
    public static String getString(String key, String[] fillIns)
    {
        String msg = null;
        
        try
        {
            msg = RESOURCE_BUNDLE.getString(key);
        }
        catch (MissingResourceException e)
        {
            return '!' + key + '!';
        }

        try
        {
            msg = MessageFormat.format(msg, fillIns);
        }
        catch (IllegalArgumentException e)
        {
            // try to do argument substitution as best as possible
            for (int i = 0; i < fillIns.length; i++)
            {
                String fillIn = fillIns[i];
                msg = msg.replaceAll("\\{"+i+"\\}", fillIn);  //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        // replace the remaining place holders
        //msg = msg.replaceAll("\\{\\d+\\}", "!MISSING_SUBSTITUTION!");  //$NON-NLS-1$ //$NON-NLS-2$
        msg = msg.replaceAll(" \"?\\{\\d+\\}\"?", "");  //$NON-NLS-1$ //$NON-NLS-2$
        return msg;
    }
}