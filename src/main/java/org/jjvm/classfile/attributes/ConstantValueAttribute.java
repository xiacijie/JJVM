package org.jjvm.classfile.attributes;

import org.jjvm.classfile.ClassReader;

public class ConstantValueAttribute implements AttributeInfo {
    private int constantValueIndex;

    @Override
    public void readInfo(ClassReader classReader)  {
        constantValueIndex = Short.toUnsignedInt(classReader.readUint16());
    }

    public int getConstantValueIndex() {
        return constantValueIndex;
    }
}
