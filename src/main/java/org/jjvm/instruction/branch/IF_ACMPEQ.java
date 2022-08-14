package org.jjvm.instruction.branch;

import org.jjvm.instruction.BranchInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;
import org.jjvm.runtime.heap.JJObject;

public class IF_ACMPEQ extends BranchInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        JJObject ref2 = stack.popRef();
        JJObject ref1 = stack.popRef();

        if (ref1 == ref2) {
            frame.branch(offset);
        }
        
    }
    
}
