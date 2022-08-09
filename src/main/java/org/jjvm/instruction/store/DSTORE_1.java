package org.jjvm.instruction.store;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class DSTORE_1 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        DSTORE.dstore(frame, 1);
    }
    
}
