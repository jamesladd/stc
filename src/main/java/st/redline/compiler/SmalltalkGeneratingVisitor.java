/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

import org.objectweb.asm.*;
import st.redline.classloader.Source;

public class SmalltalkGeneratingVisitor extends SmalltalkBaseVisitor<Void> implements SmalltalkVisitor<Void>, Opcodes {

    private final Source source;

    public SmalltalkGeneratingVisitor(Source source) {
        this.source = source;
    }
}
