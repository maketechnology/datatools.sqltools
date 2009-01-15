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
package org.eclipse.datatools.sqltools.result.internal.core;

import java.io.Serializable;
import java.util.List;

import org.eclipse.datatools.sqltools.result.OperationCommand;
import org.eclipse.datatools.sqltools.result.core.IResultManagerListener;
import org.eclipse.datatools.sqltools.result.model.IResultInstance;
import org.eclipse.datatools.sqltools.result.model.ResultItem;

/**
 * Manages all results.
 *
 * @author Dafan Yang
 */
public interface IResultManager extends Serializable
{
    /**
     * Returns all currently available result instances.
     * 
     * @return a list of <code>IResultInstance</code> instances
     */
    public IResultInstance[] getAllResults();

    /**
     * Removes the specified result instance.
     * 
     * @param instance the result instance
     */
    public void removeResultInstance(IResultInstance instance);
    
    /**
     * Removes the specified result instances.
     * 
     * @param instances the result instances
     */
    public void removeResultInstances(IResultInstance[] instances);

    /**
     * Creates a new result instance that support external client to terminate.
     * 
     * @param operation the <code>OperationCommand</code> instance
     * @param terminateHandler when external client try to terminate the instance, this runnable's run method will be
     *            called.
     * @return the newly-created result instance
     */
    public IResultInstance createNewResultInstance(OperationCommand operation, Runnable terminateHandler);

    /**
     * Adds listener
     * 
     * @param listener the listener
     */
    public void addResultManagerListener(IResultManagerListener listener);

    /**
     * Removes listener
     * 
     * @param listener the listener
     */
    public void removeResultManagerListener(IResultManagerListener listener);

    /**
     * Removes all finished result instance.
     */
    public void removeAllFinished();

    /**
     * Given the OperationCommand, returns the instance. The returned instance can be a nested result (sub-result)
     * 
     * @param cmd the operation command
     * @return the result instance
     */
    public IResultInstance getInstance(OperationCommand cmd);

    /**
     * Notifies all the listeners of this append event
     * 
     * @param instance the result instance
     * @param r the result item
     * @param index the index of this item
     */
    public void fireAppended(IResultInstance instance, ResultItem r, int index);

    /**
     * Notifies all the listeners of this status change event
     * 
     * @param instance the result instance
     */
    public void fireStatusUpdated(IResultInstance instance);
    
    /**
     * Notifies all the listeners of this instance reset event
     * 
     * @param instance the result instance
     */
    public void fireInstanceReset(IResultInstance instance);
    
    /**
     * Notifies all the listeners of this parameters show event
     * 
     * @param instance the result instance
     * @param params the <code>Parameter</code> instances list
     */
    public void fireParametersShow(IResultInstance instance, List params);

    /**
     * A new sub-result has been added
     * @param operation the operation request instance
     * @param instance the sub-result instance
     */
    public void newSubResultCreated(OperationCommand operation, IResultInstance instance);
}
