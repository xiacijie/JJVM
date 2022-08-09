package org.jjvm.instruction.rem;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class LREM extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        long v2 = stack.popLong();
        long v1 = stack.popLong();
        if (v2 == 0) {
            System.out.println("java.lang.ArithmeticException: / by zero");
            System.exit(1);
        }
        long result = v1 % v2;
        stack.pushLong(result);
    }
    
}
