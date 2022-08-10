package org.jjvm.instruction.shift;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class ISHR extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        int shift = v2 & 0x1f;
        int result = v1 >> shift;
        stack.pushInt(result);
    }
    
}
