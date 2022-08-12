package org.jjvm.classfile.attributes;

import org.jjvm.classfile.ClassReader;

public class LocalVariableTableAttribute implements AttributeInfo {
    private LocalVariableTableEntry[] localVariableTable;

    @Override
    public void readInfo(ClassReader classReader)  {
        int localVariableTableLength = Short.toUnsignedInt(classReader.readUint16());
        localVariableTable = new LocalVariableTableEntry[localVariableTableLength];
        for (int i = 0; i < localVariableTableLength; i ++) {
            localVariableTable[i] = new LocalVariableTableEntry(
                    Short.toUnsignedInt(classReader.readUint16()),
                    Short.toUnsignedInt(classReader.readUint16()),
                    Short.toUnsignedInt(classReader.readUint16()),
                    Short.toUnsignedInt(classReader.readUint16()),
                    Short.toUnsignedInt(classReader.readUint16())
            );
        }
    }

    public LocalVariableTableEntry[] getLocalVariableTable() {
        return localVariableTable;
    }
}
