package org.jjvm.classfile.constants;

import org.jjvm.classfile.ClassReader;

public class ConstantIntegerInfo implements ConstantInfo {
    private int value;

    public int getValue() {
        return value;
    }
    
    @Override
    public void readInfo(ClassReader classReader) {
        value = classReader.readUint32();
    }

}
