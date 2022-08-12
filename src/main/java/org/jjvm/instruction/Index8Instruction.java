package org.jjvm.instruction;

import org.jjvm.instruction.base.BytecodeReader;
import org.jjvm.runtime.Frame;

abstract public class Index8Instruction implements Instruction {
    public int index;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        index = Byte.toUnsignedInt(reader.readUint8());
        
    }

    @Override
    abstract public void execute(Frame frame);
    
}
