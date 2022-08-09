package org.jjvm.instruction.math;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class LSHR extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        int v2 = stack.popInt();
        long v1 = stack.popLong();
        int s = v2 & 0x3f;
        long result = v1 >> s;
        stack.pushLong(result);
        
    }
    
}
