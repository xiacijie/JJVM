package org.jjvm.instruction.math;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class DREM extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack operandStack =frame.operandStack;
        double v2 = operandStack.popDouble();
        double v1 = operandStack.popDouble();
        double result = v1 % v2;
        operandStack.pushDouble(result);
    }
    
}
