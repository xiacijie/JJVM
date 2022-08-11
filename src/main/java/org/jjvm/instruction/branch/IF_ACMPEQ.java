package org.jjvm.instruction.branch;

import org.jjvm.instruction.BranchInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class IF_ACMPEQ extends BranchInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        Object ref2 = stack.popRef();
        Object ref1 = stack.popRef();

        if (ref1 == ref2) {
            frame.branch(offset);
        }
        
    }
    
}
