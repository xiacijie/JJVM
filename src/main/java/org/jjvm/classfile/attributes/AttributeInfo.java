package org.jjvm.classfile.attributes;

import org.jjvm.classfile.ClassReader;
import org.jjvm.classfile.ClassFileConstantPool;

public interface AttributeInfo {
    public void readInfo(ClassReader classReader) ;

    static public AttributeInfo[] readAttributes(ClassReader classReader, ClassFileConstantPool constantPool)  {
        int attributesCount = Short.toUnsignedInt(classReader.readUint16());
        AttributeInfo[] attributes = new AttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i ++) {
            attributes[i] = readAttribute(classReader, constantPool);
        }
        return attributes;
    }

    static public AttributeInfo readAttribute(ClassReader classReader, ClassFileConstantPool constantPool)  {
        int attrNameIndex = Short.toUnsignedInt(classReader.readUint16());
        String attrName = constantPool.getUtf8(attrNameIndex);
        long attrLen = Integer.toUnsignedLong(classReader.readUint32());
        AttributeInfo attributeInfo = newAttributeInfo(attrName, attrLen, constantPool);
        attributeInfo.readInfo(classReader);
        return attributeInfo;
    }

    static public AttributeInfo newAttributeInfo(String attrName, long attrLen, ClassFileConstantPool constantPool) {
        switch (attrName) {
            case "Code":
                return new CodeAttribute(constantPool);
            case "ConstantValue":
                return new ConstantValueAttribute();
            case "Deprecated":
                return new DeprecatedAttribute();
            case "Exceptions":
                return new ExceptionAttribute();
            case "LineNumberTable":
                return new LineNumberTableAttribute();
            case "LocalVariableTable":
                return new LocalVariableTableAttribute();
            case "SourceFile":
                return new SourceFileAttribute(constantPool);
            case "Synthetic":
                return new SyntheticAttribute();
            default:
                return new UnparsedAttribute(attrName, attrLen);
        }
    }
}
