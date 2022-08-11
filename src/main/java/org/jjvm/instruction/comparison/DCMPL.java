package org.jjvm.instruction.comparison;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class DCMPL extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        double v2 = stack.popDouble();
        double v1 = stack.popDouble();

        if (Double.isNaN(v1) || Double.isNaN(v2)) {
            stack.pushInt(-1);
            return;
        }

        if (v1 > v2) {
            stack.pushInt(1);
        }
        else if (v1 == v2) {
            stack.pushInt(0);
        }
        else {
            stack.pushInt(-1);
        }
    }
    
}
