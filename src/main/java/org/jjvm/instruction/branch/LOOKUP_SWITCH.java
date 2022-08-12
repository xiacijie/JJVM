package org.jjvm.instruction.branch;

import org.jjvm.instruction.Instruction;
import org.jjvm.instruction.base.BytecodeReader;
import org.jjvm.runtime.Frame;

public class LOOKUP_SWITCH implements Instruction {
    private int defaultOffset;
    private int npairs;
    private int[] matchOffsets;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        reader.skipPadding();
        defaultOffset = reader.readInt32();
        npairs = reader.readInt32();
        matchOffsets = reader.readInt32s(npairs * 2);
        
    }

    @Override
    public void execute(Frame frame) {
        int key = frame.operandStack.popInt();
        for (int  i = 0; i < npairs * 2; i += 2) {
            if (matchOffsets[i] == key) {
                int offset = matchOffsets[i+1];
                frame.branch(offset);
                return;
            }
        }

        frame.branch(defaultOffset);
    }
    
}
