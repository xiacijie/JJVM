package org.jjvm.classfile.attributes;

import org.jjvm.classfile.ClassReader;

public class LineNumberTableAttribute implements AttributeInfo {
    private LineNumberTableEntry[] lineNumberTable;

    @Override
    public void readInfo(ClassReader classReader) throws Exception {
        int lineNumberTableLength = Short.toUnsignedInt(classReader.readUint16());
        lineNumberTable = new LineNumberTableEntry[lineNumberTableLength];
        for (int i = 0; i < lineNumberTableLength; i ++) {
            lineNumberTable[i] = new LineNumberTableEntry(
                Short.toUnsignedInt(classReader.readUint16()),
                Short.toUnsignedInt(classReader.readUint16())
            );
        }
    }

    public LineNumberTableEntry[] getLineNumberTable() {
        return lineNumberTable;
    }
}
