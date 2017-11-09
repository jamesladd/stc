/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

import st.redline.classloader.Source;

interface Emitter {

    byte[] generatedBytes();

    void openClass(Source source);

    void closeClass(boolean returnRequired);

    Emitter blockEmitter();

    void openBlock(int blockId, boolean isMethodBlock);

    String closeBlock(int blockId);

    void emit(Statement statement);

    void emitInitTemporaries(int index);
}
