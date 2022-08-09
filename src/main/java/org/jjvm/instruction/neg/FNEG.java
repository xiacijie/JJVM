package org.jjvm.instruction.neg;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class FNEG extends NoOpInstruction{

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        float value = stack.popFloat();
        stack.pushFloat(-value);        
    }
    
}
