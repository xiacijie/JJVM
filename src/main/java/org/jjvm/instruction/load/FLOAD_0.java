package org.jjvm.instruction.load;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class FLOAD_0 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        FLOAD.fload(frame, 0);
    }
    
}
