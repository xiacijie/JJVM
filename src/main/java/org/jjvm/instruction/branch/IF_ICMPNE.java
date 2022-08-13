package org.jjvm.instruction.branch;

import org.jjvm.instruction.BranchInstruction;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.OperandStack;

public class IF_ICMPNE extends BranchInstruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack;
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        
        System.out.println(v1);
        System.out.println(v2);
        
        if (v1 != v2) {

            frame.branch(offset);
        }
    }
    
}
