package org.jjvm.instruction.load;

import org.jjvm.instruction.Index8Instruction;
import org.jjvm.runtime.Frame;

public class LLOAD extends Index8Instruction {

    public static void lload(Frame frame, int index) {
        long value = frame.localVars.getLong(index);
        frame.operandStack.pushLong(value);
    }

    @Override
    public void execute(Frame frame) {
        lload(frame, index);
    }
    
}
