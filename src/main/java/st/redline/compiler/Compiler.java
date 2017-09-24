/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import st.redline.classloader.SmalltalkClassLoader;
import st.redline.classloader.Source;

public class Compiler {

    private static Log LOG = LogFactory.getLog(Compiler.class);

    private final Source source;

    public Compiler(Source source) {
        this.source = source;
    }

    public byte[] compile() {
        if (!haveSource())
            return null;
        return compileSource();
    }

    private byte[] compileSource() {
        return generateClass(parsedSourceContents());
    }

    private ParseTree parsedSourceContents() {
        return parse(sourceContents());
    }

    private byte[] generateClass(ParseTree tree) {
        return createGenerator(tree).generate();
    }

    private Generator createGenerator(ParseTree tree) {
        return new Generator(tree, createVisitor(new ByteCodeEmitter()));
    }

    private SmalltalkGeneratingVisitor createVisitor(Emitter emitter) {
        return new SmalltalkGeneratingVisitor(source, emitter);
    }

    private ParseTree parse(String input) {
        SmalltalkLexer lexer = new SmalltalkLexer(new ANTLRInputStream(input));
        SmalltalkParser parser = new SmalltalkParser(new CommonTokenStream(lexer));
        return parser.script();
    }

    private String sourceContents() {
        String src = source.contents();
        LOG.info("preprocessed source:\n\n" + src);
        return src;
    }

    private boolean haveSource() {
        return source != null && source.hasContent();
    }
}
