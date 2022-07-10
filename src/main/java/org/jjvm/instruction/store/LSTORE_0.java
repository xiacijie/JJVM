package org.jjvm.instruction.store;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class LSTORE_0 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        LSTORE.lstore(frame, 0);
    }
    
}
