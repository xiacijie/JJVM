package org.jjvm.classfile;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ClassReader {
    private byte[] data;
    private int nextByteToRead;

    public ClassReader(byte[] data) {
        this.data = data;
        nextByteToRead = 0;
    }

    public byte readUint8() {
        byte val = data[nextByteToRead++];
        return val;
    }

    public short readUint16() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.put(data, nextByteToRead, 2);
        nextByteToRead += 2;
        return byteBuffer.getShort(0);
    }

    public int readUint32() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.put(data, nextByteToRead, 4);
        nextByteToRead += 4;
        return byteBuffer.getInt(0);
    }

    public long readUint64() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        byteBuffer.put(data, nextByteToRead, 8);
        nextByteToRead += 8;
        return byteBuffer.getLong(0);
    }

    public short[] readUint16s() {
        short n = readUint16();
        short[] vals = new short[Short.toUnsignedInt(n)];
        for (int i = 0 ; i < n; i ++) {
            vals[i] = readUint16();
        }

        return vals;
    }

    public byte[] readBytes(int length) {
        byte[] vals = new byte[length];
        for (int i = 0; i < length; i ++) {
            vals[i] = readUint8();
        }

        return vals;
    }
}
