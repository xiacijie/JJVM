package org.jjvm.instruction.constant;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class NOP extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        return;
    }
    
}
