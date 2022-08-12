package org.jjvm.instruction.inc;

import org.jjvm.instruction.Instruction;
import org.jjvm.instruction.base.BytecodeReader;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.LocalVars;

public class IINC implements Instruction {
    public int index;
    public int constant;

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
