package org.jjvm.instruction.and;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class LAND extends NoOpInstruction{

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        long v1 = stack.popLong();
        long v2 = stack.popLong();
        stack.pushLong(v1 & v2);
    }
    
}
