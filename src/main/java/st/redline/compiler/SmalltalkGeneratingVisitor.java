package st.redline.compiler;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import st.redline.classloader.Source;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SmalltalkGeneratingVisitor extends SmalltalkBaseVisitor<Void> implements SmalltalkVisitor<Void>, Opcodes {

    private static final String[] SIGNATURES = {
            "(Ljava/lang/String;)Lst/redline/core/PrimObject;",
            "(Lst/redline/core/PrimObject;Ljava/lang/String;)Lst/redline/core/PrimObject;"
    };
    private static final Map<String, Integer> OPCODES = new HashMap<String, Integer>();
    private static final int BYTECODE_VERSION;
    static {
        int compareTo17 = new BigDecimal(System.getProperty("java.specification.version")).compareTo(new BigDecimal("1.7"));
        if (compareTo17 >= 0) {
            BYTECODE_VERSION = V1_7;
        } else {
            BYTECODE_VERSION = V1_6;
        }
    }

    private final Stack<SmalltalkVisitor<Void>> visitors = new Stack<SmalltalkVisitor<Void>>();
    private final Source source;
    private byte[] classBytes = null;

    public SmalltalkGeneratingVisitor(Source source) {
        this.source = source;
        makeClassGeneratorCurrentVisitor();
    }

    private void makeClassGeneratorCurrentVisitor() {
        visitors.push(new ClassGeneratorVisitor());
    }

    public Void visitScript(@NotNull SmalltalkParser.ScriptContext ctx) {
        currentVisitor().visitScript(ctx);
        return null;
    }

    private SmalltalkVisitor<Void> currentVisitor() {
        return visitors.peek();
    }

    private void log(String output) {
        System.out.println(output);
        System.out.flush();
    }

    private String className() {
        return source.className();
    }

    private String sourceFileExtension() {
        return source.fileExtension();
    }

    private String fullClassName() {
        return source.fullClassName();
    }

    private String superclassName() {
        return "st/redline/core/PrimObject";
    }

    private String contextName() {
        return "st/redline/core/PrimContext";
    }

    public byte[] generatedClassBytes() {
        return classBytes;
    }

    private int opcodeValue(String opcode) {
        if (!OPCODES.containsKey(opcode))
            throw new IllegalStateException("Unknown OPCODE '" + opcode + "'.");
        return OPCODES.get(opcode);
    }

    public void pop(MethodVisitor mv) {
        mv.visitInsn(POP);
    }

    public void pushLiteral(MethodVisitor mv, String literal) {
        mv.visitLdcInsn(literal);
    }

    public void pushDuplicate(MethodVisitor mv) {
        mv.visitInsn(DUP);
    }

    public void pushThis(MethodVisitor mv) {
        mv.visitVarInsn(ALOAD, 0);
    }

    public void pushReceiver(MethodVisitor mv) {
        mv.visitVarInsn(ALOAD, 1);
    }

    public void pushContext(MethodVisitor mv) {
        mv.visitVarInsn(ALOAD, 2);
    }

    public void pushNull(MethodVisitor mv) {
        mv.visitInsn(ACONST_NULL);
    }

    public void pushTemporary(MethodVisitor mv, int index) {
        pushContext(mv);
        pushNumber(mv, index);
        mv.visitMethodInsn(INVOKEVIRTUAL, contextName(), "temporaryAt", "(I)Lst/redline/core/PrimObject;");
    }

    public void pushArgument(MethodVisitor mv, int index) {
        pushContext(mv);
        pushNumber(mv, index);
        mv.visitMethodInsn(INVOKEVIRTUAL, contextName(), "argumentAt", "(I)Lst/redline/core/PrimObject;");
    }

    public void pushReference(MethodVisitor mv, String name) {
        pushReceiver(mv);
        pushLiteral(mv, name);
        mv.visitMethodInsn(INVOKEVIRTUAL, superclassName(), "reference", "(Ljava/lang/String;)Lst/redline/core/PrimObject;");
    }

    public void invokePerform(MethodVisitor mv, String selector, int argumentCount) {
        pushLiteral(mv, selector);
        mv.visitMethodInsn(INVOKEVIRTUAL, "st/redline/core/PrimObject", "perform", SIGNATURES[argumentCount]);
    }

    public void visitLine(MethodVisitor mv, int line) {
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(line, l0);
    }

    public void pushNumber(MethodVisitor mv, int value) {
        switch (value) {
            case 0: mv.visitInsn(ICONST_0); break;
            case 1: mv.visitInsn(ICONST_1); break;
            case 2: mv.visitInsn(ICONST_2); break;
            case 3: mv.visitInsn(ICONST_3); break;
            case 4: mv.visitInsn(ICONST_4); break;
            case 5: mv.visitInsn(ICONST_5); break;
            default:
                if (value > 5 && value < 128)
                    mv.visitIntInsn(BIPUSH, value);
                else // SIPUSH not supported yet.
                    throw new IllegalStateException("push of integer value " + value + " not yet supported.");
        }
    }

    // ------------------------------

    private class ClassGeneratorVisitor extends SmalltalkBaseVisitor<Void> implements SmalltalkVisitor<Void>, Opcodes {

        private final String SEND_MESSAGES_SIG = "(Lst/redline/core/PrimObject;Lst/redline/core/PrimContext;)Lst/redline/core/PrimObject;";
        private final ClassWriter cw;
        private MethodVisitor mv;
        private HashMap<String, ExtendedTerminalNode> temporaries;
        private HashMap<String, ExtendedTerminalNode> arguments;
        private Stack<StringBuilder> keywords = new Stack<StringBuilder>();

        public ClassGeneratorVisitor() {
            cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        }

        public Void visitScript(SmalltalkParser.ScriptContext ctx) {
            openJavaClass();
            openSendMessagesMethod();
            ctx.sequence().accept(currentVisitor());
            closeSendMessagesMethod();
            closeJavaClass();
            return null;
        }

        private void closeSendMessagesMethod() {
            mv.visitInsn(ARETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        private void openSendMessagesMethod() {
            mv = cw.visitMethod(ACC_PROTECTED, "sendMessages", SEND_MESSAGES_SIG, null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 1);
        }

        private void openJavaClass() {
            System.out.println("openJavaClass: " + fullClassName());
            cw.visit(BYTECODE_VERSION, ACC_PUBLIC + ACC_SUPER, fullClassName(), null, superclassName(), null);
            cw.visitSource(className() + sourceFileExtension(), null);
            makeJavaClassInitializer();
        }

        private void closeJavaClass() {
            System.out.println("closeJavaClass: " + fullClassName());
            cw.visitEnd();
            classBytes = cw.toByteArray();
        }

        private void makeJavaClassInitializer() {
            MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(0, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, superclassName(), "<init>", "()V");

            // create a Context
            mv.visitTypeInsn(NEW, contextName());
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, contextName(), "<init>", "(Lst/redline/core/PrimObject;)V");
            mv.visitVarInsn(ASTORE, 1);

            // call sendMessages with parameters: this & context
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 0); // receiver
            mv.visitVarInsn(ALOAD, 1); // context
            mv.visitMethodInsn(INVOKEVIRTUAL, fullClassName(), "sendMessages", SEND_MESSAGES_SIG);
            mv.visitInsn(POP);

            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        public Void visitSequence(SmalltalkParser.SequenceContext ctx) {
            SmalltalkParser.TempsContext temps = ctx.temps();
            if (temps != null)
                temps.accept(currentVisitor());
            SmalltalkParser.StatementsContext statements = ctx.statements();
            if (statements != null)
                statements.accept(currentVisitor());
            return null;
        }

        public Void visitTemps(@NotNull SmalltalkParser.TempsContext ctx) {
            initializeTemporaryVariableMap();
            addToTemporaryVariableMap(ctx.IDENTIFIER());
            addTemporariesToContext();
            return null;
        }

        private void addTemporariesToContext() {
            visitLine(mv, lineNumberOfFirstTemporary());
            pushContext(mv);
            pushNumber(mv, temporaries.size());
            mv.visitMethodInsn(INVOKEVIRTUAL, contextName(), "initTemporaries", "(I)V");
        }

        private int lineNumberOfFirstTemporary() {
            return temporaries.entrySet().iterator().next().getValue().getLine();
        }

        private boolean isTemporary(String key) {
            return temporaries != null && temporaries.containsKey(key);
        }

        private int indexOfTemporary(String key) {
            return temporaries.get(key).getIndex();
        }

        private void addToTemporaryVariableMap(List<TerminalNode> nodes) {
            for (TerminalNode node : nodes)
                addToTemporaryVariableMap(node);
        }

        private void addToTemporaryVariableMap(TerminalNode node) {
            addToTemporaryVariableMap(node.getText(), temporaries.size(), node);
        }

        private void addToTemporaryVariableMap(String key, int index, TerminalNode node) {
            if (temporaries.containsKey(key))
                throw new RuntimeException("Temporary '" + key + "' already defined.");
            temporaries.put(key, new ExtendedTerminalNode(node, index));
        }

        private int countOf(String input, char ch) {
            int count = 0;
            for (int i = 0, l = input.length(); i < l; i++)
                if (input.charAt(i) == ch)
                    count++;
            return count;
        }

        private void initializeKeyword() {
            keywords.push(new StringBuilder());
        }

        private void addToKeyword(String keyword) {
            keywords.peek().append(keyword);
        }

        private String removeKeyword() {
            return keywords.pop().toString();
        }

        private void initializeTemporaryVariableMap() {
            temporaries = new HashMap<String, ExtendedTerminalNode>();
        }

        private boolean isArgument(String key) {
            return arguments != null && arguments.containsKey(key);
        }

        private int indexOfArgument(String key) {
            return arguments.get(key).getIndex();
        }

        private void initializeArgumentsMap() {
            arguments = new HashMap<String, ExtendedTerminalNode>();
        }

        public Void visitStatementExpressions(@NotNull SmalltalkParser.StatementExpressionsContext ctx) {
            log("visitStatementExpressions");
            ctx.expressions().accept(currentVisitor());
            return null;
        }

        public Void visitStatementExpressionsAnswer(@NotNull SmalltalkParser.StatementExpressionsAnswerContext ctx) {
            log("visitStatementExpressionsAnswer");
            ctx.expressions().accept(currentVisitor());
            ctx.answer().accept(currentVisitor());
            return null;
        }

        public Void visitStatementAnswer(@NotNull SmalltalkParser.StatementAnswerContext ctx) {
            log("visitStatementAnswer");
            return null;
        }

        public Void visitExpression(@NotNull SmalltalkParser.ExpressionContext ctx) {
            log("visitExpression");
            SmalltalkParser.BinarySendContext binarySend = ctx.binarySend();
            if (binarySend != null)
                return binarySend.accept(currentVisitor());
            SmalltalkParser.KeywordSendContext keywordSend = ctx.keywordSend();
            if (keywordSend != null)
                return keywordSend.accept(currentVisitor());
            SmalltalkParser.CascadeContext cascade = ctx.cascade();
            if (cascade != null)
                return cascade.accept(currentVisitor());
            SmalltalkParser.AssignmentContext assignment = ctx.assignment();
            if (assignment != null)
                return assignment.accept(currentVisitor());
            SmalltalkParser.PrimitiveContext primitiveContext = ctx.primitive();
            if (primitiveContext != null)
                return primitiveContext.accept(currentVisitor());
            throw new RuntimeException("visitExpression no alternative found.");
        }

        public Void visitPrimitive(@NotNull SmalltalkParser.PrimitiveContext ctx) {
            log("visitPrimitive");
            return null;
        }

        public Void visitUnarySend(@NotNull SmalltalkParser.UnarySendContext ctx) {
            log("visitUnarySend");
            ctx.operand().accept(currentVisitor());
            SmalltalkParser.UnaryTailContext unaryTail = ctx.unaryTail();
            if (unaryTail != null)
                return unaryTail.accept(currentVisitor());
            return null;
        }

        public Void visitUnaryTail(@NotNull SmalltalkParser.UnaryTailContext ctx) {
            log("visitUnaryTail");
            ctx.unaryMessage().accept(currentVisitor());
            SmalltalkParser.UnaryTailContext unaryTail = ctx.unaryTail();
            if (unaryTail != null)
                return unaryTail.accept(currentVisitor());
            return null;
        }

        public Void visitBinarySend(@NotNull SmalltalkParser.BinarySendContext ctx) {
            log("visitBinarySend");
            ctx.unarySend().accept(currentVisitor());
            SmalltalkParser.BinaryTailContext binaryTail = ctx.binaryTail();
            if (binaryTail != null)
                return binaryTail.accept(currentVisitor());
            return null;
        }

        public Void visitBinaryTail(@NotNull SmalltalkParser.BinaryTailContext ctx) {
            log("visitBinaryTail");
            ctx.binaryMessage().accept(currentVisitor());
            SmalltalkParser.BinaryTailContext binaryTail = ctx.binaryTail();
            if (binaryTail != null)
                return binaryTail.accept(currentVisitor());
            return null;
        }

        public Void visitKeywordSend(@NotNull SmalltalkParser.KeywordSendContext ctx) {
            log("visitKeywordSend");
            ctx.binarySend().accept(currentVisitor());
            ctx.keywordMessage().accept(currentVisitor());
            return null;
        }

        public Void visitCascade(@NotNull SmalltalkParser.CascadeContext ctx) {
            log("visitCascade");
            SmalltalkParser.BinarySendContext binarySend = ctx.binarySend();
            if (binarySend != null)
                return binarySend.accept(currentVisitor());
            SmalltalkParser.KeywordSendContext keywordSend = ctx.keywordSend();
            if (keywordSend != null)
                return keywordSend.accept(currentVisitor());
            for (SmalltalkParser.MessageContext message : ctx.message())
                message.accept(currentVisitor());
            return null;
        }

        public Void visitAssignment(@NotNull SmalltalkParser.AssignmentContext ctx) {
            log("visitAssignment");
            return null;
        }

        public Void visitMessage(@NotNull SmalltalkParser.MessageContext ctx) {
            log("visitMessage");
            SmalltalkParser.UnaryMessageContext unaryMessage = ctx.unaryMessage();
            if (unaryMessage != null)
                return unaryMessage.accept(currentVisitor());
            SmalltalkParser.KeywordMessageContext keywordMessage = ctx.keywordMessage();
            if (keywordMessage != null)
                return keywordMessage.accept(currentVisitor());
            SmalltalkParser.BinaryMessageContext binaryMessage = ctx.binaryMessage();
            if (binaryMessage != null)
                return binaryMessage.accept(currentVisitor());
            throw new RuntimeException("visitMessage no alternative found.");
        }

        public Void visitUnaryMessage(@NotNull SmalltalkParser.UnaryMessageContext ctx) {
            log("visitUnaryMessage");
            return null;
        }

        public Void visitBinaryMessage(@NotNull SmalltalkParser.BinaryMessageContext ctx) {
            log("visitBinaryMessage " + ctx.BINARY_SELECTOR().getSymbol().getText());
            TerminalNode binarySelector = ctx.BINARY_SELECTOR();
            SmalltalkParser.UnarySendContext unarySend = ctx.unarySend();
            if (unarySend != null)
                unarySend.accept(currentVisitor());
            SmalltalkParser.OperandContext operand = ctx.operand();
            if (operand != null)
                operand.accept(currentVisitor());
            visitLine(mv, binarySelector.getSymbol().getLine());
            invokePerform(mv, binarySelector.getSymbol().getText(), 1);
            return null;
        }

        public Void visitKeywordMessage(@NotNull SmalltalkParser.KeywordMessageContext ctx) {
            log("visitKeywordMessage");
            initializeKeyword();
            for (SmalltalkParser.KeywordPairContext keywordPair : ctx.keywordPair())
                keywordPair.accept(currentVisitor());
            visitLine(mv, ctx.keywordPair().get(0).KEYWORD().getSymbol().getLine());
            String keyword = removeKeyword();
            // REMOVE ONCE WE HAVE SUCCESSFULLY PUSHED KEYWORD PAIR VALUES.
            pushNull(mv); // REMOVE ONCE WE HAVE SUCCESSFULLY PUSHED KEYWORD PAIR VALUES.
            invokePerform(mv, keyword, countOf(keyword, ':'));
            return null;
        }

        public Void visitKeywordPair(@NotNull SmalltalkParser.KeywordPairContext ctx) {
            log("visitKeywordPair " + ctx.KEYWORD().getSymbol().getText());
            TerminalNode keyword = ctx.KEYWORD();
            String part = keyword.getSymbol().getText();
            visitLine(mv, keyword.getSymbol().getLine());
            addToKeyword(part);
            SmalltalkParser.BinarySendContext binarySend = ctx.binarySend();
            if (binarySend != null)
                return binarySend.accept(currentVisitor());
            throw new RuntimeException("visitKeywordPair binary send expected.");
        }

        public Void visitOperand(@NotNull SmalltalkParser.OperandContext ctx) {
            log("visitOperand");
            SmalltalkParser.LiteralContext literal = ctx.literal();
            if (literal != null)
                return literal.accept(currentVisitor());
            SmalltalkParser.ReferenceContext reference = ctx.reference();
            if (reference != null)
                return reference.accept(currentVisitor());
            SmalltalkParser.SubexpressionContext subexpression = ctx.subexpression();
            if (subexpression != null)
                return subexpression.accept(currentVisitor());
            throw new RuntimeException("visitOperand no alternative found.");
        }

        public Void visitLiteral(@NotNull SmalltalkParser.LiteralContext ctx) {
            log("visitLiteral");
            SmalltalkParser.ParsetimeLiteralContext parsetimeLiteral = ctx.parsetimeLiteral();
            if (parsetimeLiteral != null)
                return parsetimeLiteral.accept(currentVisitor());
            SmalltalkParser.RuntimeLiteralContext runtimeLiteral = ctx.runtimeLiteral();
            if (runtimeLiteral != null)
                return runtimeLiteral.accept(currentVisitor());
            throw new RuntimeException("visitLiteral no alternative found.");
        }

        public Void visitRuntimeLiteral(@NotNull SmalltalkParser.RuntimeLiteralContext ctx) {
            log("visitRuntimeLiteral");
            return null;
        }

        public Void visitParsetimeLiteral(@NotNull SmalltalkParser.ParsetimeLiteralContext ctx) {
            log("visitParsetimeLiteral");
            SmalltalkParser.PseudoVariableContext pseudoVariable = ctx.pseudoVariable();
            if (pseudoVariable != null)
                return pseudoVariable.accept(currentVisitor());
            SmalltalkParser.NumberContext number = ctx.number();
            if (number != null)
                return number.accept(currentVisitor());
            SmalltalkParser.CharConstantContext charConstant = ctx.charConstant();
            if (charConstant != null)
                return charConstant.accept(currentVisitor());
            SmalltalkParser.LiteralArrayContext literalArray = ctx.literalArray();
            if (literalArray != null)
                return literalArray.accept(currentVisitor());
            SmalltalkParser.StringContext string = ctx.string();
            if (string != null)
                return string.accept(currentVisitor());
            SmalltalkParser.SymbolContext symbol = ctx.symbol();
            if (symbol != null)
                return symbol.accept(currentVisitor());
            throw new RuntimeException("visitParsetimeLiteral no alternative found.");
        }

        public Void visitSymbol(@NotNull SmalltalkParser.SymbolContext ctx) {
            log("visitSymbol #" + ctx.bareSymbol().IDENTIFIER().getSymbol().getText());
            return null;
        }

        public Void visitReference(@NotNull SmalltalkParser.ReferenceContext ctx) {
            log("visitReference " + ctx.variable().IDENTIFIER().getSymbol().getText());
            TerminalNode identifier = ctx.variable().IDENTIFIER();
            String name = identifier.getSymbol().getText();
            visitLine(mv, identifier.getSymbol().getLine());
            if (isTemporary(name))
                pushTemporary(mv, indexOfTemporary(name));
            else if (isArgument(name))
                pushArgument(mv, indexOfArgument(name));
            else
                pushReference(mv, name);
            return null;
        }

        public Void visitSubexpression(@NotNull SmalltalkParser.SubexpressionContext ctx) {
            log("visitSubexpression");
            return null;
        }

        public Void visitVariable(@NotNull SmalltalkParser.VariableContext ctx) {
            throw new RuntimeException("visitVariable should have been handed before now.");
        }
    }

    private class ExtendedTerminalNode {

        private final TerminalNode node;
        private final int index;

        public ExtendedTerminalNode(TerminalNode node, int index) {
            this.node = node;
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public int getLine() {
            return getSymbol().getLine();
        }

        public Token getSymbol() {
            return node.getSymbol();
        }
    }

    static {
        OPCODES.put("V1_1", 196653);
        OPCODES.put("V1_2", 46);
        OPCODES.put("V1_3", 47);
        OPCODES.put("V1_4", 48);
        OPCODES.put("V1_5", 49);
        OPCODES.put("V1_6", 50);
        OPCODES.put("V1_7", 51);
        OPCODES.put("ACC_PUBLIC", 1);
        OPCODES.put("ACC_PRIVATE", 2);
        OPCODES.put("ACC_PROTECTED", 4);
        OPCODES.put("ACC_STATIC", 8);
        OPCODES.put("ACC_FINAL", 16);
        OPCODES.put("ACC_SUPER", 32);
        OPCODES.put("ACC_SYNCHRONIZED", 32);
        OPCODES.put("ACC_VOLATILE", 64);
        OPCODES.put("ACC_BRIDGE", 64);
        OPCODES.put("ACC_VARARGS", 128);
        OPCODES.put("ACC_TRANSIENT", 128);
        OPCODES.put("ACC_NATIVE", 256);
        OPCODES.put("ACC_INTERFACE", 512);
        OPCODES.put("ACC_ABSTRACT", 1024);
        OPCODES.put("ACC_STRICT", 2048);
        OPCODES.put("ACC_SYNTHETIC", 4096);
        OPCODES.put("ACC_ANNOTATION", 8192);
        OPCODES.put("ACC_ENUM", 16384);
        OPCODES.put("ACC_DEPRECATED", 131072);
        OPCODES.put("T_BOOLEAN", 4);
        OPCODES.put("T_CHAR", 5);
        OPCODES.put("T_FLOAT", 6);
        OPCODES.put("T_DOUBLE", 7);
        OPCODES.put("T_BYTE", 8);
        OPCODES.put("T_SHORT", 9);
        OPCODES.put("T_INT", 10);
        OPCODES.put("T_LONG", 11);
        OPCODES.put("F_NEW", -1);
        OPCODES.put("F_FULL", 0);
        OPCODES.put("F_APPEND", 1);
        OPCODES.put("F_CHOP", 2);
        OPCODES.put("F_SAME", 3);
        OPCODES.put("F_SAME1", 4);
        OPCODES.put("TOP", TOP);
        OPCODES.put("INTEGER", INTEGER);
        OPCODES.put("FLOAT", FLOAT);
        OPCODES.put("DOUBLE", DOUBLE);
        OPCODES.put("LONG", LONG);
        OPCODES.put("NULL", NULL);
        OPCODES.put("UNINITIALIZED_THIS", UNINITIALIZED_THIS);
        OPCODES.put("NOP", 0);
        OPCODES.put("ACONST_NULL", 1);
        OPCODES.put("ICONST_M1", 2);
        OPCODES.put("ICONST_0", 3);
        OPCODES.put("ICONST_1", 4);
        OPCODES.put("ICONST_2", 5);
        OPCODES.put("ICONST_3", 6);
        OPCODES.put("ICONST_4", 7);
        OPCODES.put("ICONST_5", 8);
        OPCODES.put("LCONST_0", 9);
        OPCODES.put("LCONST_1", 10);
        OPCODES.put("FCONST_0", 11);
        OPCODES.put("FCONST_1", 12);
        OPCODES.put("FCONST_2", 13);
        OPCODES.put("DCONST_0", 14);
        OPCODES.put("DCONST_1", 15);
        OPCODES.put("BIPUSH", 16);
        OPCODES.put("SIPUSH", 17);
        OPCODES.put("LDC", 18);
        OPCODES.put("ILOAD", 21);
        OPCODES.put("LLOAD", 22);
        OPCODES.put("FLOAD", 23);
        OPCODES.put("DLOAD", 24);
        OPCODES.put("ALOAD", 25);
        OPCODES.put("IALOAD", 46);
        OPCODES.put("LALOAD", 47);
        OPCODES.put("FALOAD", 48);
        OPCODES.put("DALOAD", 49);
        OPCODES.put("AALOAD", 50);
        OPCODES.put("BALOAD", 51);
        OPCODES.put("CALOAD", 52);
        OPCODES.put("SALOAD", 53);
        OPCODES.put("ISTORE", 54);
        OPCODES.put("LSTORE", 55);
        OPCODES.put("FSTORE", 56);
        OPCODES.put("DSTORE", 57);
        OPCODES.put("ASTORE", 58);
        OPCODES.put("IASTORE", 79);
        OPCODES.put("LASTORE", 80);
        OPCODES.put("FASTORE", 81);
        OPCODES.put("DASTORE", 82);
        OPCODES.put("AASTORE", 83);
        OPCODES.put("BASTORE", 84);
        OPCODES.put("CASTORE", 85);
        OPCODES.put("SASTORE", 86);
        OPCODES.put("POP", 87);
        OPCODES.put("POP2", 88);
        OPCODES.put("DUP", 89);
        OPCODES.put("DUP_X1", 90);
        OPCODES.put("DUP_X2", 91);
        OPCODES.put("DUP2", 92);
        OPCODES.put("DUP2_X1", 93);
        OPCODES.put("DUP2_X2", 94);
        OPCODES.put("SWAP", 95);
        OPCODES.put("IADD", 96);
        OPCODES.put("LADD", 97);
        OPCODES.put("FADD", 98);
        OPCODES.put("DADD", 99);
        OPCODES.put("ISUB", 100);
        OPCODES.put("LSUB", 101);
        OPCODES.put("FSUB", 102);
        OPCODES.put("DSUB", 103);
        OPCODES.put("IMUL", 104);
        OPCODES.put("LMUL", 105);
        OPCODES.put("FMUL", 106);
        OPCODES.put("DMUL", 107);
        OPCODES.put("IDIV", 108);
        OPCODES.put("LDIV", 109);
        OPCODES.put("FDIV", 110);
        OPCODES.put("DDIV", 111);
        OPCODES.put("IREM", 112);
        OPCODES.put("LREM", 113);
        OPCODES.put("FREM", 114);
        OPCODES.put("DREM", 115);
        OPCODES.put("INEG", 116);
        OPCODES.put("LNEG", 117);
        OPCODES.put("FNEG", 118);
        OPCODES.put("DNEG", 119);
        OPCODES.put("ISHL", 120);
        OPCODES.put("LSHL", 121);
        OPCODES.put("ISHR", 122);
        OPCODES.put("LSHR", 123);
        OPCODES.put("IUSHR", 124);
        OPCODES.put("LUSHR", 125);
        OPCODES.put("IAND", 126);
        OPCODES.put("LAND", 127);
        OPCODES.put("IOR", 128);
        OPCODES.put("LOR", 129);
        OPCODES.put("IXOR", 130);
        OPCODES.put("LXOR", 131);
        OPCODES.put("IINC", 132);
        OPCODES.put("I2L", 133);
        OPCODES.put("I2F", 134);
        OPCODES.put("I2D", 135);
        OPCODES.put("L2I", 136);
        OPCODES.put("L2F", 137);
        OPCODES.put("L2D", 138);
        OPCODES.put("F2I", 139);
        OPCODES.put("F2L", 140);
        OPCODES.put("F2D", 141);
        OPCODES.put("D2I", 142);
        OPCODES.put("D2L", 143);
        OPCODES.put("D2F", 144);
        OPCODES.put("I2B", 145);
        OPCODES.put("I2C", 146);
        OPCODES.put("I2S", 147);
        OPCODES.put("LCMP", 148);
        OPCODES.put("FCMPL", 149);
        OPCODES.put("FCMPG", 150);
        OPCODES.put("DCMPL", 151);
        OPCODES.put("DCMPG", 152);
        OPCODES.put("IFEQ", 153);
        OPCODES.put("IFNE", 154);
        OPCODES.put("IFLT", 155);
        OPCODES.put("IFGE", 156);
        OPCODES.put("IFGT", 157);
        OPCODES.put("IFLE", 158);
        OPCODES.put("IF_ICMPEQ", 159);
        OPCODES.put("IF_ICMPNE", 160);
        OPCODES.put("IF_ICMPLT", 161);
        OPCODES.put("IF_ICMPGE", 162);
        OPCODES.put("IF_ICMPGT", 163);
        OPCODES.put("IF_ICMPLE", 164);
        OPCODES.put("IF_ACMPEQ", 165);
        OPCODES.put("IF_ACMPNE", 166);
        OPCODES.put("GOTO", 167);
        OPCODES.put("JSR", 168);
        OPCODES.put("RET", 169);
        OPCODES.put("TABLESWITCH", 170);
        OPCODES.put("LOOKUPSWITCH", 171);
        OPCODES.put("IRETURN", 172);
        OPCODES.put("LRETURN", 173);
        OPCODES.put("FRETURN", 174);
        OPCODES.put("DRETURN", 175);
        OPCODES.put("ARETURN", 176);
        OPCODES.put("RETURN", 177);
        OPCODES.put("GETSTATIC", 178);
        OPCODES.put("PUTSTATIC", 179);
        OPCODES.put("GETFIELD", 180);
        OPCODES.put("PUTFIELD", 181);
        OPCODES.put("INVOKEVIRTUAL", 182);
        OPCODES.put("INVOKESPECIAL", 183);
        OPCODES.put("INVOKESTATIC", 184);
        OPCODES.put("INVOKEINTERFACE", 185);
        OPCODES.put("INVOKEDYNAMIC", 186);
        OPCODES.put("NEW", 187);
        OPCODES.put("NEWARRAY", 188);
        OPCODES.put("ANEWARRAY", 189);
        OPCODES.put("ARRAYLENGTH", 190);
        OPCODES.put("ATHROW", 191);
        OPCODES.put("CHECKCAST", 192);
        OPCODES.put("INSTANCEOF", 193);
        OPCODES.put("MONITORENTER", 194);
        OPCODES.put("MONITOREXIT", 195);
        OPCODES.put("MULTIANEWARRAY", 197);
        OPCODES.put("IFNULL", 198);
        OPCODES.put("IFNONNULL", 199);
    }
}
