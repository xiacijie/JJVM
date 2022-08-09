package org.jjvm.instruction.div;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class IDIV extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        if (v2 == 0) {
            System.out.println("java.lang.ArithmeticException: / by zero");
            System.exit(1);
        }

        int result = v1 / v2;
        stack.pushInt(result);
    }
    
}
