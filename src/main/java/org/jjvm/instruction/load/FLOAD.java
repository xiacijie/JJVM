package org.jjvm.instruction.load;

import org.jjvm.instruction.Index8Instruction;
import org.jjvm.runtime.Frame;

public class FLOAD extends Index8Instruction {

    public static void fload(Frame frame, int index) {
        float value = frame.localVars.getFloat(index);
        frame.operandStack.pushFloat(value);
    }

    @Override
    public void execute(Frame frame) {
        fload(frame, index);
    }
    
}
