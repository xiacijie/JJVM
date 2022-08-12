package org.jjvm.classfile.constants;

import org.jjvm.classfile.ClassReader;
import org.jjvm.classfile.ConstantPool;
import org.jjvm.util.Tuple;

public class ConstantMemberrefInfo implements ConstantInfo {
    private ConstantPool constantPool;
    private int classIndex;
    private int nameAndTypeIndex;

    public ConstantMemberrefInfo(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader classReader) {
        classIndex = Short.toUnsignedInt(classReader.readUint16());
        nameAndTypeIndex = Short.toUnsignedInt(classReader.readUint16());
    }

    public String getClassName()  {
        return constantPool.getClassName(classIndex);
    }

    public Tuple<String, String> getNameAndDescriptor()  {
        return constantPool.getNameAndType(nameAndTypeIndex);
    }
    
}
