package org.jjvm.instruction.constant;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class FCONST_0 extends NoOpInstruction{

    @Override
    public void execute(Frame frame) {
        frame.operandStack.pushFloat(0.0F);
    }
}
