package org.jjvm.instruction.branch;

import org.jjvm.instruction.BranchInstruction;
import org.jjvm.runtime.Frame;

public class IF_LE extends BranchInstruction {

    @Override
    public void execute(Frame frame) {
        int value = frame.operandStack.popInt();
        if (value <= 0) {
            frame.branch(offset);
        }
        
    }
    
}
