package org.jjvm.instruction;

import org.jjvm.instruction.base.BytecodeReader;
import org.jjvm.runtime.Frame;

abstract public class BranchInstruction implements Instruction {
    protected int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        offset = reader.readInt16();
    }

    @Override
    abstract public void execute(Frame frame);
    
}
