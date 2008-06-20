/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenSource;

/**
 * A token stream that is aware of the current lookahead.
 * 
 * @author Jan K�hnlein - Initial contribution and API
 */
public class XtextTokenStream extends CommonTokenStream {

    private int currentLookahead;
    private int lookaheadConsumedByParent;

    public XtextTokenStream() {
        super();
    }

    public XtextTokenStream(TokenSource tokenSource, int channel) {
        super(tokenSource, channel);
    }

    public XtextTokenStream(TokenSource tokenSource) {
        super(tokenSource);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.antlr.runtime.CommonTokenStream#LA(int)
     */
    @Override
    public int LA(int i) {
        currentLookahead = Math.max(currentLookahead, i);
        return super.LA(i);
    }

    /**
     * @return the currentLookahead
     */
    public int getCurrentLookahead() {
        return currentLookahead;
    }

    /**
     * @return the lookaheadConsumedByParent
     */
    public int getLookaheadConsumedByParent() {
        return lookaheadConsumedByParent;
    }

    public void resetLookahead() {
        currentLookahead = 0;
        lookaheadConsumedByParent = 0;
    }

    public void decrementLookahead() {
        --currentLookahead;
    }

    public void consumeLookahead() {
        ++lookaheadConsumedByParent;
    }
}
