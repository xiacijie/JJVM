package org.jjvm.instruction.branch;

import org.jjvm.instruction.BranchInstruction;
import org.jjvm.runtime.Frame;

public class GO_TO extends BranchInstruction{

    @Override
    public void execute(Frame frame) {
        frame.branch(offset);
    }
    
}
