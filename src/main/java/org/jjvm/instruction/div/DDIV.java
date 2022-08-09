package org.jjvm.instruction.div;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class DDIV extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        double v2 = stack.popDouble();
        double v1 = stack.popDouble();
        double result = v1 / v2;
        stack.pushDouble(result);
    }
    
}
