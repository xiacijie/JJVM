package org.jjvm.instruction.load;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class ALOAD_3 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        ALOAD.aload(frame, 3);
    }
    
}
