package org.jjvm.instruction.constant;

import org.jjvm.instruction.Instruction;
import org.jjvm.instruction.base.BytecodeReader;
import org.jjvm.runtime.Frame;

public class SIPUSH implements Instruction{
    private short value;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        value = reader.readInt16();
        
    }

    @Override
    public void execute(Frame frame) {
        frame.operandStack.pushInt((int)value);   
    }
    
}
