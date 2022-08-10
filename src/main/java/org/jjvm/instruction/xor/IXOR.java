package org.jjvm.instruction.xor;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class IXOR extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        int v1 = stack.popInt();
        int v2 = stack.popInt();
        int result = v1 ^ v2;
        stack.pushInt(result);
    }
    
}
