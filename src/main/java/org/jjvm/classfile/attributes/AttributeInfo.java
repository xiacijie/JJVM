package org.jjvm.classfile.attributes;

import org.jjvm.classfile.ClassReader;
import org.jjvm.classfile.ConstantPool;

public interface AttributeInfo {
    public void readInfo(ClassReader classReader);

    static public AttributeInfo[] readAttributes(ClassReader classReader, ConstantPool constantPool) {
        int attributesCount = Short.toUnsignedInt(classReader.readUint16());
        AttributeInfo[] attributes = new AttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i ++) {
            attributes[i] = readAttribute(classReader, constantPool);
        }
        return attributes;
    }

    static public AttributeInfo readAttribute(ClassReader classReader, ConstantPool constantPool) throws Exception {
        int attrNameIndex = Short.toUnsignedInt(classReader.readUint16());
        String attrName = constantPool.getUtf8(attrNameIndex);
        long attrLen = Integer.toUnsignedLong(classReader.readUint32());
        AttributeInfo attributeInfo = newAttributeInfo(attrName, attrLen, constantPool);
        attributeInfo.readInfo(classReader);
        return attributeInfo;
    }

    static public AttributeInfo newAttributeInfo(String attrName, long attrLen, ConstantPool constantPool) {
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
                return new SourceFileAttribute();
            case "Synthetic":
                return new SyntheticAttribute();
            default:
                return UnparsedAttribute(attrName, attrLen, null);
        }
    }
}
