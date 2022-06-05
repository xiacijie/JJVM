package org.jjvm.instruction.load;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class ILOAD_0 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        ILOAD.iload(frame, 0);
    }
    
}
