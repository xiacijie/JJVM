package org.jjvm.instruction.store;

import org.jjvm.instruction.Index8Instruction;
import org.jjvm.runtime.Frame;

public class FSTORE extends Index8Instruction {
    public static void fstore(Frame frame, int index) {
        float value = frame.operandStack.popFloat();
        frame.localVars.setFloat(index, value);
    }

    @Override
    public void execute(Frame frame) {
        fstore(frame, index);
    }
    
}
