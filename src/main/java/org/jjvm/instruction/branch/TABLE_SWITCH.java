package org.jjvm.instruction.branch;

import org.jjvm.instruction.Instruction;
import org.jjvm.instruction.base.BytecodeReader;
import org.jjvm.runtime.Frame;

public class TABLE_SWITCH implements Instruction {

    private int defaultOffset;
    private int low;
    private int high;
    private int[] jumpOffsets;
    
    @Override
    public void fetchOperands(BytecodeReader reader) {
        reader.skipPadding();
        defaultOffset = reader.readInt32();
        low = reader.readInt32();
        high = reader.readInt32();
        int jumpOffsetCount = high - low + 1;
        jumpOffsets = reader.readInt32s(jumpOffsetCount);
    }

    @Override
    public void execute(Frame frame) {
        int index = frame.operandStack.popInt();
        int offset;
        if (index >= low && index <= high) {
            offset = jumpOffsets[index - low];
        }
        else {
            offset = defaultOffset;
        }

        frame.branch(offset);
    }
    
}
