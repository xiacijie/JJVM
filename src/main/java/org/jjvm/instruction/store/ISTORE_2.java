package org.jjvm.instruction.store;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class ISTORE_2 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
    ISTORE.istore(frame, 2);
    }
    
}
