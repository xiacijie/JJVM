package org.jjvm.instruction.mul;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class DMUL extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        double v2 = stack.popDouble();
        double v1 = stack.popDouble();
        double result = v1 * v2;
        stack.pushDouble(result);
    }
    
}
