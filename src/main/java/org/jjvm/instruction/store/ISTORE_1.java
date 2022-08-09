package org.jjvm.instruction.store;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class ISTORE_1 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
       ISTORE.istore(frame, 1);
    }
    
}
