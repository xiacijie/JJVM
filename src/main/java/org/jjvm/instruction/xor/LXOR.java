package org.jjvm.instruction.xor;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class LXOR extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        long v1 = stack.popLong();
        long v2 = stack.popLong();
        long result = v1 ^ v2;
        stack.pushLong(result);
    }
    
}
