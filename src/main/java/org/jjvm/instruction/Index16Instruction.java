package org.jjvm.instruction;

import org.jjvm.instruction.base.BytecodeReader;
import org.jjvm.runtime.Frame;

abstract public class Index16Instruction implements Instruction {

    public int index;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        index = Short.toUnsignedInt(reader.readUint16());
    }

    @Override
    abstract public void execute(Frame frame);
    
}
