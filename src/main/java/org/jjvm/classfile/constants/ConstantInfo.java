package org.jjvm.classfile.constants;

import org.jjvm.classfile.ClassReader;

public interface ConstantInfo {
    public void readInfo(ClassReader classReader);

    static public ConstantInfo readConstantInfo(ClassReader classReader, ConstantPool constantPool) throws Exception {
        int tag = Byte.toUnsignedInt(classReader.readUint8());
        ConstantInfo constantInfo = newConstantInfo(tag, constantPool);
        constantInfo.readInfo(classReader);
        return constantInfo;
    }

    static public ConstantInfo newConstantInfo(int tag, ConstantPool constantPool) throws Exception {
        switch (tag) {
            case ConstantTag.CONSTANT_Integer:
                return new ConstantIntegerInfo();
            case ConstantTag.CONSTANT_Float:
                return new ConstantFloatInfo();
            case ConstantTag.CONSTANT_Long:
                return new ConstantLongInfo();
            case ConstantTag.CONSTANT_Double:
                return new ConstantDoubleInfo();
            case ConstantTag.CONSTANT_Utf8:
                return new ConstantUtf8Info();
            case ConstantTag.CONSTANT_String:
                return new ConstantStringInfo(constantPool);
            case ConstantTag.CONSTANT_Class:
                return new ConstantClassInfo(constantPool);
            case ConstantTag.CONSTANT_Fieldref:
                return new ConstantFieldrefInfo(constantPool);
            case ConstantTag.CONSTANT_Methodref:
                return new ConstantInterfaceMethodrefInfo(constantPool);
            case ConstantTag.CONSTANT_InterfaceMethodref:
                return new ConstantInterfaceMethodrefInfo(constantPool);
            case ConstantTag.CONSTANT_NameAndType:
                return new ConstantNameAndTypeInfo(constantPool);
            case ConstantTag.CONSTANT_MethodType:
                // return new ConstantMethodTypeInfo();
            case ConstantTag.CONSTANT_MethodHandle:
                // return new ConstantMethodHandleInfo();
            case ConstantTag.CONSTANT_InvokeDynamic:
                // return new ConstantInvokeDynamicInfo();
                throw new Exception("invoke dynamic not supported yet!");
            default:
                throw new Exception("java.lang.ClassFormatError: constant pool tag!");
            }
    }
}
