package org.jjvm.instruction.add;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class IADD extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        int v1 = stack.popInt();
        int v2 = stack.popInt();
        stack.pushInt(v1 + v2);
    }
    
}
