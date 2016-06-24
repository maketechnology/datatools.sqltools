package org.eclipse.ui;

import org.eclipse.jface.action.IAction;

public interface IKeyBindingService {
    String[] getScopes();

    void registerAction(IAction action);

    void setScopes(String[] scopes);

    void unregisterAction(IAction action);
}
