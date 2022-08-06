package org.jjvm.instruction.math;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class IREM extends NoOpInstruction{

    @Override
    public void execute(Frame frame) {
        OperandStack operandStack = frame.operandStack;
        int v2 = operandStack.popInt();
        int v1 = operandStack.popInt();
        if (v2 == 0) {
            System.out.println("java.lang.ArithmeticException: / by zero");
            System.exit(1);
        }

        int result = v1 % v2;
        operandStack.pushInt(result);
    }
    
}
