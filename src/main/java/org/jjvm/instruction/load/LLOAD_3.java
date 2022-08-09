package org.jjvm.instruction.load;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class LLOAD_3 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        LLOAD.lload(frame, 3);
    }
    
}
