package org.jjvm.instruction.branch;

import javax.swing.text.AbstractDocument.BranchElement;

import org.jjvm.instruction.BranchInstruction;
import org.jjvm.instruction.NoOpInstruction;
import org.jjvm.runtime.Frame;

public class IF_LT extends BranchInstruction {

    @Override
    public void execute(Frame frame) {
        int value = frame.operandStack.popInt();
        if (value < 0) {
            frame.branch(offset);
        }
    }
    
}
