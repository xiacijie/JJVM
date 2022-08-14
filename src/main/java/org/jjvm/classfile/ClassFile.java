package org.jjvm.classfile;

import org.jjvm.classfile.attributes.AttributeInfo;
import org.jjvm.exception.JJException;

public class ClassFile {
    public long magic;
    public int minorVersion;
    public int majorVersion;
    public ConstantPool constantPool;
    public int accessFlags;
    public int thisClass;
    public int superClass;
    public int[] interfaces;
    public MemberInfo[] fields;
    public MemberInfo[] methods;
    public AttributeInfo[] attributes;

    public static ClassFile parse(byte[] classData)  {
        ClassReader classReader = new ClassReader(classData);
        ClassFile classFile = new ClassFile();
        classFile.read(classReader);
        return classFile;
    }

    public String getClassName()  {
        return constantPool.getClassName(thisClass);
    }

    public String getSuperClassName()  {
        if (superClass > 0) {
            return constantPool.getClassName(superClass);
        }

        return "java.lang.Object";
    }

    public String[] getInterfaceNames()  {
        String[] interfaceNames = new String[interfaces.length];
        for (int i = 0; i < interfaces.length; i ++) {
            int cpIndex = interfaces[i];
            interfaceNames[i] = constantPool.getClassName(cpIndex);
        }

        return interfaceNames;
    }

    private void read(ClassReader classReader)  {
        readAndCheckMagic(classReader);
        readAndCheckVersion(classReader);
        constantPool = new ConstantPool();
        constantPool.readConstantPool(classReader);
        accessFlags = Short.toUnsignedInt(classReader.readUint16());
        thisClass = Short.toUnsignedInt(classReader.readUint16());
        superClass = Short.toUnsignedInt(classReader.readUint16());
        short[] interfaces_shorts = classReader.readUint16s();
        interfaces = new int[interfaces_shorts.length];
        for (int i = 0; i < interfaces_shorts.length; i ++) {
            interfaces[i] = Short.toUnsignedInt(interfaces_shorts[i]);
        }

        fields = MemberInfo.readMembers(classReader, constantPool);
        methods = MemberInfo.readMembers(classReader, constantPool);
        attributes = AttributeInfo.readAttributes(classReader, constantPool);
    }

    private void readAndCheckMagic(ClassReader classReader) {
        magic = Integer.toUnsignedLong(classReader.readUint32());
  
        if (magic != Long.parseLong("CAFEBABE", 16)) {
            JJException.throwException("java.lang.ClassFormatError: magic!");
        }
    }

    private void readAndCheckVersion(ClassReader classReader) {
        minorVersion = Short.toUnsignedInt(classReader.readUint16());
        majorVersion = Short.toUnsignedInt(classReader.readUint16());
        switch (majorVersion) {
            case 45:
                return;
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                if (minorVersion == 0)
                    return;
        }
        JJException.throwException("java.lang.UnsupportedClassVersionError!");
    }
}
