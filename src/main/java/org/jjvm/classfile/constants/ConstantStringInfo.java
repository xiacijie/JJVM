package org.jjvm.classfile.constants;

import org.jjvm.classfile.ClassReader;
import org.jjvm.classfile.ConstantPool;

public class ConstantStringInfo implements ConstantInfo {
    private ConstantPool constantPool;
    private int stringIndex;

    public ConstantStringInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader classReader) {
        stringIndex = Short.toUnsignedInt(classReader.readUint16());
    }

    public String getString()  {
        return constantPool.getUtf8(stringIndex);
    }
    
}
