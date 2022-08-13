package org.jjvm.instruction.constant;

import org.jjvm.instruction.Instruction;
import org.jjvm.instruction.base.BytecodeReader;
import org.jjvm.runtime.Frame;

public class BIPUSH implements Instruction {
    private int value;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        value = (int)reader.readInt8();
    }

    @Override
    public void execute(Frame frame) {
        frame.operandStack.pushInt((int)value);
    }
    
}
