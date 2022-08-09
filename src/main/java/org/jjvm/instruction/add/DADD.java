package org.jjvm.instruction.add;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class DADD extends NoOpInstruction{

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        double v1 = stack.popDouble();
        double v2 = stack.popDouble();
        stack.pushDouble(v1 + v2);
    }
    
}
