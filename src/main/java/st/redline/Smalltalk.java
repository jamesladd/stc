package st.redline;

import st.redline.kernel.PrimObject;

public interface Smalltalk {

    PrimObject createString(String javaString);
    PrimObject createSymbol(String javaString);
    PrimObject createInteger(String javaString);
    PrimObject createCharacter(String javaString);
    PrimObject booleanSingleton(String javaString);
    PrimObject nilSingleton(String javaString);
}
