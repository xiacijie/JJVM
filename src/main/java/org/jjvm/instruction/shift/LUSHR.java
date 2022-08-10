package org.jjvm.instruction.shift;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class LUSHR extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        int v2 = stack.popInt();
        long v1 = stack.popLong();
        int shift = v2 & 0x3f;
        long result = v1 >>> shift;
        stack.pushLong(result);
    }
    
}
