package org.jjvm.instruction.constant;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class ACONST_NULL extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        frame.operandStack.pushRef(null);
    }
}
