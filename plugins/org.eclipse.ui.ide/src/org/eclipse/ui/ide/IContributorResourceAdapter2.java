package org.eclipse.ui.ide;

import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IContributorResourceAdapter;

public interface IContributorResourceAdapter2 extends IContributorResourceAdapter {

    public ResourceMapping getAdaptedResourceMapping(IAdaptable adaptable);
}