package org.jjvm.instruction.store;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class ASTORE_3 extends NoOpInstruction{

    @Override
    public void execute(Frame frame) {
        ASTORE.astore(frame, 3);
    }
    
}
