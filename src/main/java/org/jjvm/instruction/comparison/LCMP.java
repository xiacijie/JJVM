package org.jjvm.instruction.comparison;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class LCMP extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        long v2 = stack.popLong();
        long v1 = stack.popLong();

        if (v1 > v2) {
            stack.pushInt(1);
        }
        else if (v1 == v2) {
            stack.pushInt(0);
        }
        else {
            stack.pushInt(-1);
        }
        
    }
    
}
