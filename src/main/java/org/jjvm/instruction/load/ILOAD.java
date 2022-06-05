package org.jjvm.instruction.load;

import org.jjvm.instruction.Index8Instruction;
import org.jjvm.runtime.Frame;

public class ILOAD extends Index8Instruction {
    public static void iload(Frame frame, int index) {
        int value = frame.localVars.getInt(index);
        frame.operandStack.pushInt(value);
    }

    @Override
    public void execute(Frame frame) {
        iload(frame, index);
    }
    
}
