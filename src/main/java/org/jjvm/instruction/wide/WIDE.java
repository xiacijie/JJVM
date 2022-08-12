package org.jjvm.instruction.wide;

import org.jjvm.instruction.Instruction;
import org.jjvm.instruction.base.BytecodeReader;
import org.jjvm.instruction.inc.IINC;
import org.jjvm.instruction.load.ALOAD;
import org.jjvm.instruction.load.DLOAD;
import org.jjvm.instruction.load.FLOAD;
import org.jjvm.instruction.load.ILOAD;
import org.jjvm.instruction.load.LLOAD;
import org.jjvm.instruction.store.ASTORE;
import org.jjvm.instruction.store.DSTORE;
import org.jjvm.instruction.store.ISTORE;
import org.jjvm.runtime.Frame;

public class WIDE implements Instruction {
    private Instruction extendedInstruction;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        int opcode = Byte.toUnsignedInt(reader.readUint8());
        switch (opcode) {
            case 0x15:
                ILOAD iload = new ILOAD();
                iload.index = Short.toUnsignedInt(reader.readUint16());
                extendedInstruction = iload;
                break;
            case 0x16:
                LLOAD lload = new LLOAD();
                lload.index = Short.toUnsignedInt(reader.readUint16());
                extendedInstruction = lload;
                break;
            case 0x17:
                FLOAD fload = new FLOAD();
                fload.index = Short.toUnsignedInt(reader.readUint16());
                extendedInstruction = fload;
                break;
            case 0x18:
                DLOAD dload = new DLOAD();
                dload.index = Short.toUnsignedInt(reader.readUint16());
                extendedInstruction = dload;
                break;
            case 0x19:
                ALOAD aload = new ALOAD();
                aload.index = Short.toUnsignedInt(reader.readUint16());
                extendedInstruction = aload;
                break;
            case 0x36:
                ISTORE istore = new ISTORE();
                istore.index = Short.toUnsignedInt(reader.readUint16());
                extendedInstruction = istore;
                break;
            case 0x39:
                DSTORE dstore = new DSTORE();
                dstore.index = Short.toUnsignedInt(reader.readUint16());
                extendedInstruction = dstore;
                break;
            case 0x3a:
                ASTORE astore = new ASTORE();
                astore.index = Short.toUnsignedInt(reader.readUint16());
                extendedInstruction = astore;
                break;
            case 0x84:
                IINC iinc = new IINC();
                iinc.index = Short.toUnsignedInt(reader.readUint16());
                iinc.constant = reader.readInt16();
                extendedInstruction = iinc;
                break;
            case 0xa9:
                System.out.println("ret is not supported yet!");
                System.exit(1);
                break;
        }
        
    }

    @Override
    public void execute(Frame frame) {
        extendedInstruction.execute(frame);
    }
    
}
