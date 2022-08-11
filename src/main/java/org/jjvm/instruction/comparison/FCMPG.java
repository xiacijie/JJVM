package org.jjvm.instruction.comparison;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class FCMPG extends NoOpInstruction{

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        float v2 = stack.popFloat();
        float v1 = stack.popFloat();
        if (Float.isNaN(v1) || Float.isNaN(v2)) {
            stack.pushInt(1);
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
