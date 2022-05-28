package org.jjvm.classfile.constants;

import org.jjvm.classfile.ClassReader;

public class ConstantFloatInfo implements ConstantInfo {
    private float value;

    public float getValue() {
        return value;
    }
    @Override
    public void readInfo(ClassReader classReader) {
        value = Float.intBitsToFloat(classReader.readUint32());
    }

}
