package org.jjvm.instruction.load;

import org.jjvm.instruction.Index8Instruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.heap.JJObject;

public class ALOAD extends Index8Instruction {
    public static void aload(Frame frame, int index) {
        JJObject ref = frame.localVars.getRef(index);
        frame.operandStack.pushRef(ref);
    }

    @Override
    public void execute(Frame frame) {
       aload(frame, index);
    }
    
}
