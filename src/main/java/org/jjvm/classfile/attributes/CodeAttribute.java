package org.jjvm.classfile.attributes;

import org.jjvm.classfile.ClassReader;
import org.jjvm.classfile.ClassFileConstantPool;
import org.jjvm.exception.JJException;

public class CodeAttribute implements AttributeInfo {
    private final ClassFileConstantPool constantPool;
    private int maxStack;
    private int maxLocals;
    private byte[] code;
    private ExceptionTableEntry[] exceptionTable;
    private AttributeInfo[] attributes;

    public CodeAttribute(ClassFileConstantPool constantPool) {
        this.constantPool =  constantPool;
    }

    @Override
    public void readInfo(ClassReader classReader)  {
        maxStack = Short.toUnsignedInt(classReader.readUint16());
        maxLocals = Short.toUnsignedInt(classReader.readUint16());
        long codeLength = Integer.toUnsignedLong(classReader.readUint32());
        if (codeLength > Integer.MAX_VALUE) {
            JJException.throwException("length " + codeLength + " too long!");
        }

        int intCodeLength = (int)codeLength;
        code = classReader.readBytes(intCodeLength);
        exceptionTable = readExceptionTable(classReader);
        attributes = AttributeInfo.readAttributes(classReader, constantPool);
    }

    private ExceptionTableEntry[] readExceptionTable(ClassReader classReader) {
        int exceptionTableLength = Short.toUnsignedInt(classReader.readUint16());
        ExceptionTableEntry[] exceptionTable = new ExceptionTableEntry[exceptionTableLength];
        for (int i = 0; i < exceptionTableLength; i ++) {
            ExceptionTableEntry exceptionTableEntry = new ExceptionTableEntry(
                    Short.toUnsignedInt(classReader.readUint16()),
                    Short.toUnsignedInt(classReader.readUint16()),
                    Short.toUnsignedInt(classReader.readUint16()),
                    Short.toUnsignedInt(classReader.readUint16())
            );

            exceptionTable[i] = exceptionTableEntry;
        }
        return exceptionTable;
    }

    public int getMaxStack() {
        return maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public byte[] getCode() {
        return code;
    }

    public ExceptionTableEntry[] getExceptionTable() {
        return exceptionTable;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }
}
