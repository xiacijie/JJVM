package org.jjvm.classfile.constants;

import org.jjvm.classfile.ClassReader;

public class ConstantClassInfo implements ConstantInfo {
    private ConstantPool constantPool;
    private int nameIndex;

    public ConstantClassInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader classReader) {
        nameIndex = Short.toUnsignedInt(classReader.readUint16());
    }

    public String getName() throws Exception {
        return constantPool.getUtf8(nameIndex);
    }
    
    
}
