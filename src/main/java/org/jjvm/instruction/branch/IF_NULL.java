package org.jjvm.instruction.branch;

import org.jjvm.instruction.BranchInstruction;
import org.jjvm.runtime.Frame;

public class IF_NULL extends BranchInstruction {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.operandStack.popRef();
        if (ref == null) {
            frame.branch(offset);
        }
        
    }
    
}
