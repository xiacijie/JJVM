package org.jjvm.instruction.branch;

import org.jjvm.instruction.BranchInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class IF_ICMPGE extends BranchInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        int v2 = stack.popInt();
        int v1 = stack.popInt();

        if (v1 >= v2) {
            frame.branch(offset);
        }
        
    }
    
}
