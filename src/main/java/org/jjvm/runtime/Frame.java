package org.jjvm.runtime;

public class Frame {
    public Frame lower;
    public LocalVars localVars;
    public OperandStack operandStack;
    public JJThread thread;
    public int nextPC;

    public Frame(int maxLocals, int maxStack, JJThread thread)  {
        localVars = new LocalVars(maxLocals);
        operandStack = new OperandStack(maxStack);
        this.thread = thread;
        nextPC = 0;
    }

    public void branch(int offset) {
        int currentPC = thread.pc;
        nextPC = currentPC + offset; 
    }
 
}
