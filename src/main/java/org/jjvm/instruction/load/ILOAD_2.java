package org.jjvm.instruction.load;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class ILOAD_2 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        ILOAD.iload(frame, 2);
    }
    
}
