package st.redline.kernel;

import st.redline.Smalltalk;

public class RedlineSmalltalk extends PrimObject implements Smalltalk {

    public RedlineSmalltalk() {
        this.javaValue("RedlineSmalltalk");
    }

    @Override
    public PrimObject createString(String value) {
        // TODO.JCL - When Smalltalk String is available create one, ie: after bootstrap
        PrimObject object = new PrimObject();
        object.javaValue(value);
        return object;
    }

    @Override
    public PrimObject createSymbol(String value) {
        // TODO.JCL - When Smalltalk Symbol is available create one, ie: after bootstrap
        PrimObject object = new PrimObject();
        object.javaValue(value);
        return object;
    }

    @Override
    public PrimObject createInteger(String value) {
        // TODO.JCL - When Smalltalk Symbol is available create one, ie: after bootstrap
        PrimObject object = new PrimObject();
        object.javaValue(Integer.valueOf(value));
        return object;
    }

    @Override
    public PrimObject createCharacter(String value) {
        // TODO.JCL - When Smalltalk Symbol is available create one, ie: after bootstrap
        PrimObject object = new PrimObject();
        object.javaValue(value.charAt(0));
        return object;
    }

    @Override
    public PrimObject booleanSingleton(String value) {
        // TODO.JCL - When Smalltalk Symbol is available create one, ie: after bootstrap
        PrimObject object = new PrimObject();
        object.javaValue(Boolean.valueOf(value));
        return object;
    }

    @Override
    public PrimObject nilSingleton(String value) {
        // TODO.JCL - When Smalltalk Symbol is available create one, ie: after bootstrap
        PrimObject object = new PrimObject();
        object.javaValue("nil");
        return object;
    }
}
