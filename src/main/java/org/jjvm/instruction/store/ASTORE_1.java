package org.jjvm.instruction.store;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class ASTORE_1 extends NoOpInstruction{

    @Override
    public void execute(Frame frame) {
        ASTORE.astore(frame, 1);
    }
    
}
