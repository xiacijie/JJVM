package org.jjvm.instruction.neg;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class DNEG extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        double value = stack.popDouble();
        stack.pushDouble(-value);        
    }
    
}
