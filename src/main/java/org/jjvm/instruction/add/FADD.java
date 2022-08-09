package org.jjvm.instruction.add;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class FADD extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        float v1 = stack.popFloat();
        float v2 = stack.popFloat();
        stack.pushFloat(v1 + v2);
    }
    
}
