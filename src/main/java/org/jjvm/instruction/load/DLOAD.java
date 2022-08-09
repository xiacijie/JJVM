package org.jjvm.instruction.load;

import org.jjvm.instruction.Index8Instruction;
import org.jjvm.runtime.Frame;

public class DLOAD extends Index8Instruction {
    public static void dload(Frame frame, int index) {
        double value = frame.localVars.getDouble(index);
        frame.operandStack.pushDouble(value);
    }

    @Override
    public void execute(Frame frame) {
        dload(frame, index);
    }
}
