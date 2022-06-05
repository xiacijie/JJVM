package org.jjvm.instruction;

import org.jjvm.instruction.base.BytecodeReader;
import org.jjvm.runtime.Frame;

public interface Instruction {
    public void fetchOperands(BytecodeReader reader);
    public void execute(Frame frame);
}
