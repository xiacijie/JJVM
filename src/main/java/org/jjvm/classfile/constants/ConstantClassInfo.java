package org.jjvm.classfile.constants;

import org.jjvm.classfile.ClassReader;
import org.jjvm.classfile.ClassFileConstantPool;

public class ConstantClassInfo implements ConstantInfo {
    private ClassFileConstantPool constantPool;
    private int nameIndex;

    public ConstantClassInfo(ClassFileConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader classReader) {
        nameIndex = Short.toUnsignedInt(classReader.readUint16());
    }

    public String getName()  {
        return constantPool.getUtf8(nameIndex);
    }
    
    
}
