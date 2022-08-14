package org.jjvm.classfile.constants;

import org.jjvm.classfile.ClassReader;
import org.jjvm.classfile.ClassFileConstantPool;

public class ConstantNameAndTypeInfo implements ConstantInfo {
    private int nameIndex;
    private int descriptorIndex;
    private ClassFileConstantPool constantPool;

    public ConstantNameAndTypeInfo(ClassFileConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader classReader) {
        nameIndex = Short.toUnsignedInt(classReader.readUint16());
        descriptorIndex = Short.toUnsignedInt(classReader.readUint16());        
    }

    public String getName()  {
        return constantPool.getUtf8(nameIndex);
    }

    public String getDescriptor()  {
        return constantPool.getUtf8(descriptorIndex);
    }
}
