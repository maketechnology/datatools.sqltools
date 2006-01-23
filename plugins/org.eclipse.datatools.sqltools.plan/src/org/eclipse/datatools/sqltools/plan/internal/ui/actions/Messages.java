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

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages
{
    private static final String         BUNDLE_NAME     = "org.eclipse.datatools.sqltools.plan.internal.ui.actions.messages"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private Messages()
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
    
    public static String getString(String key, Object[] args)
    {
        try
        {
            return MessageFormat.format(RESOURCE_BUNDLE.getString(key), args);
        }
        catch (MissingResourceException e)
        {
            StringBuffer argString = new StringBuffer(key);
            argString.append(":");
            for (int i = 0; i < args.length; i++)
            {
                argString.append(args[i]);
            }
            return argString.toString();
        }
    }
}