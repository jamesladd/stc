/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

class BlockStatement extends Statement {

    private final int id;

    public BlockStatement(int id) {
        super();
        this.id = id;
    }

    int id() {
        return id;
    }

    boolean isBlock() {
        return true;
    }
}
