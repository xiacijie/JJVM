package org.jjvm.instruction.store;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class ISTORE_3 extends NoOpInstruction{

    @Override
    public void execute(Frame frame) {
        ISTORE.istore(frame, 3);
    }
    
}
