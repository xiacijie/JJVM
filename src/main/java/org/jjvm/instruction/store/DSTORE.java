package org.jjvm.instruction.store;

import org.jjvm.instruction.Index8Instruction;
import org.jjvm.runtime.Frame;

public class DSTORE extends Index8Instruction {
    public static void dstore(Frame frame, int index) {
        double value = frame.operandStack.popDouble();
        frame.localVars.setDouble(index, value);
    }

    @Override
    public void execute(Frame frame) {
        dstore(frame, index);
    }
    
}
