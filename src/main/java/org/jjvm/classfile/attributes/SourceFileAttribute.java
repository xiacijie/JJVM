package org.jjvm.classfile.attributes;

import org.jjvm.classfile.ClassReader;
import org.jjvm.classfile.ClassFileConstantPool;

public class SourceFileAttribute implements AttributeInfo {
    private final ClassFileConstantPool constantPool;
    private int sourceFileIndex;

    public SourceFileAttribute(ClassFileConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader classReader)  {
        sourceFileIndex = Short.toUnsignedInt(classReader.readUint16());
    }

    public  String getFileName()  {
        return constantPool.getUtf8(sourceFileIndex);
    }
}
