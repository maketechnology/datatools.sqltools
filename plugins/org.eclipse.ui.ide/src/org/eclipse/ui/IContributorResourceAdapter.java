package org.eclipse.ui;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;

public interface IContributorResourceAdapter {

    public IResource getAdaptedResource(IAdaptable adaptable);

}
