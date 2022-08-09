package org.jjvm.instruction.load;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class LLOAD_0 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        LLOAD.lload(frame, 0);
    }
    
}
