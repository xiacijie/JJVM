package org.jjvm.classfile.constants;

import java.nio.charset.StandardCharsets;

import org.jjvm.classfile.ClassReader;

public class ConstantUtf8Info implements ConstantInfo {
    private String value;

    public String getValue() {
        return value;
    }

    @Override
    public void readInfo(ClassReader classReader) {
        int length = Short.toUnsignedInt(classReader.readUint16());
        byte[] bytes = classReader.readBytes(length);
        value = new String(bytes, StandardCharsets.UTF_8);
    }
    
}
