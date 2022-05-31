package org.jjvm.classfile.attributes;

public class LocalVariableTableEntry {
    public int startPc;
    public int length;
    public int nameIndex;
    public int descriptorIndex;
    public int index;

    public LocalVariableTableEntry(int startPc, int length, int nameIndex, int descriptorIndex, int index) {
        this.startPc = startPc;
        this.length = length;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.index = index;
    }
}
