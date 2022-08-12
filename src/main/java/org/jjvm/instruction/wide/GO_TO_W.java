package org.jjvm.instruction.wide;

import org.jjvm.instruction.Instruction;
import org.jjvm.instruction.base.BytecodeReader;
import org.jjvm.runtime.Frame;

public class GO_TO_W implements Instruction {
    public int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        offset = reader.readInt32();
    }

    @Override
    public void execute(Frame frame) {
        frame.branch(offset);
    }
    
}
