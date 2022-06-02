package org.jjvm.classfile.attributes;

import org.jjvm.classfile.ClassReader;

public class ExceptionAttribute implements AttributeInfo {

    private int[] exceptionIndexTable;

    @Override
    public void readInfo(ClassReader classReader) throws Exception {
        short[] shorts = classReader.readUint16s();
        exceptionIndexTable = new int[shorts.length];
        for (int i = 0; i < shorts.length; i ++) {
            exceptionIndexTable[i] = Short.toUnsignedInt(shorts[i]);
        }
    }

    public int[] getExceptionIndexTable() {
        return exceptionIndexTable;
    }
}
