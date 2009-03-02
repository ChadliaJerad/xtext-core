/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.service;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.impl.DefaultLinkingService;
import org.eclipse.xtext.crossref.impl.DefaultScopeProvider;
import org.eclipse.xtext.crossref.impl.Linker;
import org.eclipse.xtext.parser.SwitchingParser;
import org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.NullTokenDefProvider;
import org.eclipse.xtext.parser.packrat.ParseResultFactory;
import org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultCrossReferenceSerializer;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;
import org.eclipse.xtext.parsetree.reconstr.impl.WhitespacePreservingTokenSerializer;
import org.eclipse.xtext.resource.DefaultFragmentProvider;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResourceFactory;

import com.google.inject.Binder;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sven Efftinge
 */
public abstract class DefaultRuntimeModule extends AbstractGenericModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
	}

	public EValidator.Registry bindEValidatorRegistry() {
		return EValidator.Registry.INSTANCE;
	}

	public Class<? extends IFragmentProvider> bindIFragmentProvider() {
		return DefaultFragmentProvider.class;
	}

	public Class<? extends ITransientValueService> bindITransientValueService() {
		return DefaultTransientValueService.class;
	}

	public Class<? extends ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return DefaultCrossReferenceSerializer.class;
	}

	public Class<? extends ITokenSerializer> bindITokenSerializer() {
		return WhitespacePreservingTokenSerializer.class;
	}

	public Class<? extends IResourceFactory> bindIResourceFactory() {
		return XtextResourceFactory.class;
	}

	public Class<? extends ILinkingService> bindILinkingService() {
		return DefaultLinkingService.class;
	}

	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return DefaultScopeProvider.class;
	}

	public Class<? extends org.eclipse.xtext.crossref.ILinker> bindILinker() {
		return Linker.class;
	}

	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return DefaultTerminalConverters.class;
	}

	public Class<? extends org.eclipse.xtext.parser.ITokenToStringConverter> bindITokenToStringConverter() {
		return AntlrTokenToStringConverter.class;
	}

	public Class<? extends org.eclipse.xtext.parser.packrat.IParseResultFactory> bindIParseResultFactory() {
		return ParseResultFactory.class;
	}

	public Class<? extends org.eclipse.xtext.parser.ISwitchingParser> bindISwitchingParser() {
		return SwitchingParser.class;
	}

	public Class<? extends ITokenDefProvider> bindITokenDefProvider() {
		return NullTokenDefProvider.class;
	}

	public Class<? extends org.eclipse.xtext.parser.IAstFactory> bindIAstFactory() {
		return org.eclipse.xtext.parser.DefaultEcoreElementFactory.class;
	}
}
