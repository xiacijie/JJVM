package org.jjvm.instruction.store;

import org.jjvm.instruction.Index8Instruction;
import org.jjvm.runtime.Frame;

public class LSTORE extends Index8Instruction {

    public static void lstore(Frame frame, int index) {
        long value = frame.operandStack.popLong();
        frame.localVars.setLong(index, value);
    }

    @Override
    public void execute(Frame frame) {
        lstore(frame, index);
    }
    
}
