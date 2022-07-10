package org.jjvm.instruction.pop;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class POP2 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        frame.operandStack.popSlot();
        frame.operandStack.popSlot();
    }
    
}
