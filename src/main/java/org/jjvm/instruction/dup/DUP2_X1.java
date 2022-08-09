package org.jjvm.instruction.dup;

import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;
import org.jjvm.runtime.Slot;

public class DUP2_X1 extends NoOpInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        Slot slot1 = stack.popSlot();
        Slot slot2 = stack.popSlot();
        Slot slot3 = stack.popSlot();
        stack.pushSlot(slot2);
        stack.pushSlot(slot1);
        stack.pushSlot(slot3);
        stack.pushSlot(slot2);
        stack.pushSlot(slot1);
    }
    
}
