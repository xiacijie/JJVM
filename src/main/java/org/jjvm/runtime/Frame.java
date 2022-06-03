package org.jjvm.runtime;

public class Frame {
    public Frame lower;
    public LocalVars localVars;
    public OperandStack operandStack;

    public Frame(int maxLocals, int maxStack) throws Exception {
        localVars = new LocalVars(maxLocals);
        operandStack = new OperandStack(maxStack);
    }
 
}
