package org.jjvm.instruction.load;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class DLOAD_3 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        DLOAD.dload(frame, 3);
    }
    
}
