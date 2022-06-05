package org.jjvm.instruction.constant;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class FCONST_2 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        frame.operandStack.pushFloat(2.0F);
    }
    
}
