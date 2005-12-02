/***********************************************************************************************************************
 * Copyright (c) 2005 Sybase, Inc. All rights reserved. This program and the accompanying materials are made available
 * under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Sybase, Inc. - initial API and implementation
 **********************************************************************************************************************/

package org.eclipse.datatools.sqltools.core;

import java.util.EventListener;


/**
 * Clients that are interested in the control connection lifecycle events can implement this interface.
 * @see IControlConnectionManager
 * @see IControlConnection
 *  
 * @author Yang Liu
 * @author Hui Cao
 */
public interface IControlConnectionListener extends EventListener
{
    /**
     * A new control connection is created and added into the control connection manager 
     * @param con the control connection
     */
    public void controlConnectionAdded(IControlConnection con);

    /**
     * The control connection is destroyed and removed from the control connection manager 
     * @param con the control connection
     */
    public void controlConnectionDetached(IControlConnection con);

    /**
     * The control connection has changed its status  
     * @param con the control connection
     */
    public void controlConnectionRefreshed(IControlConnection con);

    /**
     * The routine object <code>proc</code> which is managed by the control connection has changed. 
     * @param con the control connection
     */
    public void controlConnectionRefreshed(IControlConnection con, ProcIdentifier proc);
}
