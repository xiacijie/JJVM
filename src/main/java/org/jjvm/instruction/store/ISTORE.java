package org.jjvm.instruction.store;

import org.jjvm.instruction.Index8Instruction;
import org.jjvm.runtime.Frame;

public class ISTORE extends Index8Instruction {

    public static void istore(Frame frame, int index) {
        int value = frame.operandStack.popInt();
        frame.localVars.setInt(index, value);
    }

    @Override
    public void execute(Frame frame) {
        istore(frame, index);
    }
    
}
