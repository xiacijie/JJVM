package org.jjvm.classfile.attributes;

import org.jjvm.classfile.ClassReader;
import org.jjvm.exception.JJException;

public class UnparsedAttribute implements AttributeInfo {
    private final String name;
    private final long length;
    private byte[] info;

    public UnparsedAttribute(String name, long length) {
        this.name = name;
        this.length = length;
        info = null;
    }
    @Override
    public void readInfo(ClassReader classReader)  {
        if (length > Integer.MAX_VALUE) {
            JJException.throwException("length" + length + " too long!");
        }
        int intLength = (int)length;
        info = classReader.readBytes(intLength);
    }
    
}
