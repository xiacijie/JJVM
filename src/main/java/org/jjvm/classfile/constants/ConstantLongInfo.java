package org.jjvm.classfile.constants;

import org.jjvm.classfile.ClassReader;

public class ConstantLongInfo implements ConstantInfo {
    private long value;

    public long getValue() {
        return value;
    }
    
    @Override
    public void readInfo(ClassReader classReader) {
        value = classReader.readUint64();
    }

}
