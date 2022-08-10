package org.jjvm.instruction.conversion;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class F2I extends NoOpInstruction{

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        stack.pushInt((int)stack.popFloat());
    }
    
}
