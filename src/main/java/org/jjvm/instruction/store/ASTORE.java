package org.jjvm.instruction.store;

import org.jjvm.instruction.Index8Instruction;
import org.jjvm.runtime.Frame;

public class ASTORE extends Index8Instruction {
    public static void astore(Frame frame, int index) {
        Object ref = frame.operandStack.popRef();
        frame.localVars.setRef(index, ref);
    }

    @Override
    public void execute(Frame frame) {
        astore(frame, index);
    }
    
}
