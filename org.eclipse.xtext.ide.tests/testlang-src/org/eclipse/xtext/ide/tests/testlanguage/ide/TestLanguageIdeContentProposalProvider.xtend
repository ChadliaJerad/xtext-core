/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.ide

import com.google.inject.Inject
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider
import org.eclipse.xtext.ide.tests.testlanguage.services.TestLanguageGrammarAccess

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class TestLanguageIdeContentProposalProvider extends IdeContentProposalProvider {
	
	@Inject extension TestLanguageGrammarAccess
	
	override protected _createProposals(RuleCall ruleCall, ContentAssistContext context, IIdeContentProposalAcceptor acceptor) {
		if (ruleCall.rule == typeDeclarationRule) {
			acceptor.accept(proposalCreator.createSnippet('''type ${1|A,B,C|} {
				
			}''', "Sample Snippet", context), 0)
		}
		super._createProposals(ruleCall, context, acceptor)
	}
	
}