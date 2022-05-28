package org.jjvm.classfile.constants;

import org.jjvm.classfile.ClassReader;
import org.jjvm.classfile.ConstantPool;

public class ConstantNameAndTypeInfo implements ConstantInfo {
    private int nameIndex;
    private int descriptorIndex;
    private ConstantPool constantPool;

    public ConstantNameAndTypeInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader classReader) {
        nameIndex = Short.toUnsignedInt(classReader.readUint16());
        descriptorIndex = Short.toUnsignedInt(classReader.readUint16());        
    }

    public String getName() throws Exception {
        return constantPool.getUtf8(nameIndex);
    }

    public String getDescriptor() throws Exception {
        return constantPool.getUtf8(descriptorIndex);
    }
}
