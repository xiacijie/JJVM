package org.jjvm.instruction.neg;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class INEG extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        int value = stack.popInt();
        stack.pushInt(-value);        
    }
    
}
