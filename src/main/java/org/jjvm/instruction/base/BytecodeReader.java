package org.jjvm.instruction.base;

public class BytecodeReader {
    public int pc;
    public byte[] code;

    public void reset(byte[] code, int pc) {
        this.code = code;
        this.pc = pc;
    }

    public byte readUint8() {
        byte i = code[pc];
        pc++;
        return i;
    }

    public byte readInt8() {
        return readUint8();
    }

    public short readUint16() {
        byte byte1 = readUint8();
        byte byte2 = readUint8();
        return (short) ((byte1 << 8) | byte2);
    }

    public short readInt16() {
        return readUint16();
    }

    public int readInt32() {
        byte byte1 = readUint8();
        byte byte2 = readUint8();
        byte byte3 = readUint8();
        byte byte4 = readUint8();

        return (byte1 << 24) | (byte2 << 16) | (byte3 << 8) | byte4;
    }

    public int[] readInt32s(int n) {
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = readInt32();
        }
        return values;
    }

    public void skipPadding() {
        while (pc % 4 != 0) {
            readUint8();
        }
    }

    
}
