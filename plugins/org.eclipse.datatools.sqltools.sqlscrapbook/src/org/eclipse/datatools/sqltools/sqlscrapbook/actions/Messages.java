/*******************************************************************************
 * Copyright (c) 2008 Sybase, Inc. and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sybase, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.sqltools.sqlscrapbook.actions;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {
	private static final String BUNDLE_NAME = Messages.class.getPackage().getName() + ".messages";//$NON-NLS-1$

	public static String OpenScrapbookAction_scrapbook_title;
	
	private Messages() {
		// Do not instantiate
	}

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
