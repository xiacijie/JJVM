package org.jjvm.instruction.constant;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class ICONST_M1 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        frame.operandStack.pushInt(-1);
    }
    
}
