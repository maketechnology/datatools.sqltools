package org.eclipse.ui.navigator;

import org.eclipse.jface.viewers.NavigatorDecoratingLabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.internal.navigator.NavigatorContentService;

public class CommonViewerRAP extends CommonViewer {

    private final NavigatorContentService contentService;

    public CommonViewerRAP(String aViewerId, Composite aParent, int aStyle) {
        super(aViewerId, aParent, aStyle);
        contentService = new NavigatorContentService(aViewerId, this);
    }


    @Override
    protected void init() {

        setUseHashlookup(true);
        setContentProvider(contentService.createCommonContentProvider());
        super.setLabelProvider(new NavigatorDecoratingLabelProvider(contentService.createCommonLabelProvider()));

    }

}
