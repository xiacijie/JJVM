package org.jjvm.instruction;

import org.jjvm.instruction.base.BytecodeReader;
import org.jjvm.runtime.Frame;

abstract public class NoOpInstruction implements Instruction {

    @Override
    public void fetchOperands(BytecodeReader reader) {
        return;
    }

    @Override
    abstract public void execute(Frame frame);
    
}
