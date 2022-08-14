package org.jjvm.classfile;

import org.jjvm.classfile.constants.ConstantClassInfo;
import org.jjvm.classfile.constants.ConstantDoubleInfo;
import org.jjvm.classfile.constants.ConstantInfo;
import org.jjvm.classfile.constants.ConstantLongInfo;
import org.jjvm.classfile.constants.ConstantNameAndTypeInfo;
import org.jjvm.classfile.constants.ConstantUtf8Info;
import org.jjvm.exception.JJException;
import org.jjvm.util.Tuple;

public class ClassFileConstantPool {
    
    private ConstantInfo[] constantInfos;

    public int size() {
        return constantInfos.length;
    }
    
    public void readConstantPool(ClassReader classReader)  {
        int constantPoolCount = Short.toUnsignedInt(classReader.readUint16());
        this.constantInfos = new ConstantInfo[constantPoolCount];
        for (int i = 1; i < constantPoolCount; i ++) {
            constantInfos[i] = ConstantInfo.readConstantInfo(classReader, this);
            if (constantInfos[i] instanceof ConstantLongInfo 
                || constantInfos[i] instanceof ConstantDoubleInfo) {
                i++;
            }
        }
    }

    public ConstantInfo getConstantInfo(int index) {
        ConstantInfo constantInfo = constantInfos[index];
        if (constantInfo != null) {
            return constantInfo;
        }
        JJException.throwException("Invalid constant pool index!");
        return null;
    }

    public Tuple<String,String> getNameAndType(int index)  {
        ConstantNameAndTypeInfo ntInfo = (ConstantNameAndTypeInfo)getConstantInfo(index);
        return new Tuple<String,String>(ntInfo.getName(), ntInfo.getDescriptor());
    }

    public String getClassName(int index)  {
        ConstantClassInfo classInfo = (ConstantClassInfo)getConstantInfo(index);
        return classInfo.getName();
    }

    public String getUtf8(int index)  {
        ConstantUtf8Info utf8Info = (ConstantUtf8Info)getConstantInfo(index);
        return utf8Info.getValue();
    }
}
