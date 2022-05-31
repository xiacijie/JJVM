package org.jjvm.classfile.attributes;

import org.jjvm.classfile.ClassReader;
import org.jjvm.classfile.ConstantPool;

public class SourceFileAttribute implements AttributeInfo {
    private final ConstantPool constantPool;
    private int sourceFileIndex;

    public SourceFileAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader classReader) throws Exception {
        sourceFileIndex = Short.toUnsignedInt(classReader.readUint16());
    }

    public  String getFileName() throws Exception {
        return constantPool.getUtf8(sourceFileIndex);
    }
}
