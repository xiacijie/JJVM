package org.jjvm.classfile.constants;

import org.jjvm.classfile.ClassReader;

public class ConstantDoubleInfo implements ConstantInfo{
    private double value;

    public double getValue() {
        return value;
    }
    
    @Override
    public void readInfo(ClassReader classReader) {
        value = Double.longBitsToDouble(classReader.readUint64());
    }
    
}
