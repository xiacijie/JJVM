package org.jjvm.instruction.store;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class FSTORE_0 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
       FSTORE.fstore(frame, 0);
    }
    
}
