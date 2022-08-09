package org.jjvm.instruction.math;

import org.jjvm.instruction.Instruction;
import org.jjvm.instruction.base.BytecodeReader;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.LocalVars;

public class IINC implements Instruction {
    private int index;
    private int constant;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        index = Byte.toUnsignedInt(reader.readUint8());
        constant = reader.readInt8();
    }

    @Override
    public void execute(Frame frame) {
        LocalVars localVars = frame.localVars;
        int value = localVars.getInt(index);
        value += constant;
        localVars.setInt(index, value);
    }
    
}
