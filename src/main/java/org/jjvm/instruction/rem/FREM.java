package org.jjvm.instruction.rem;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class FREM extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        float v2 = stack.popFloat();
        float v1 = stack.popFloat();
        float result = v1 % v2;
        stack.pushFloat(result);
    }
    
}
