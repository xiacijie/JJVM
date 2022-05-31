package org.jjvm.classfile.attributes;

import org.jjvm.classfile.ClassReader;

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
    public void readInfo(ClassReader classReader) throws Exception {
        if (length > Integer.MAX_VALUE) {
            throw new Exception("length" + length + " too long!");
        }
        int intLength = (int)length;
        info = classReader.readBytes(intLength);
    }
    
}
