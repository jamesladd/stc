/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution. */
package st.redline.compiler;

class BlockStatement extends Statement {

    private final int blockId;

    public BlockStatement(int blockId) {
        this.blockId = blockId;
    }

    boolean isBlock() {
        return true;
    }

    int blockId() {
        return blockId;
    }
}
