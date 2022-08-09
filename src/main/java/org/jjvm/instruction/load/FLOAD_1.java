package org.jjvm.instruction.load;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class FLOAD_1 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        FLOAD.fload(frame, 1);
        
    }
    
}
