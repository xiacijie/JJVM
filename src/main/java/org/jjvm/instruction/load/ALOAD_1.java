package org.jjvm.instruction.load;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class ALOAD_1 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        ALOAD.aload(frame, 1);
    }
    
}
