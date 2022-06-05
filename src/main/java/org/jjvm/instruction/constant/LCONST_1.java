package org.jjvm.instruction.constant;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class LCONST_1 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        frame.operandStack.pushLong(1);
    }
    
}
