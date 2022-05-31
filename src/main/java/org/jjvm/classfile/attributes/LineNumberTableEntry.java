package org.jjvm.classfile.attributes;

public class LineNumberTableEntry {
    public int startPc;

    public int lineNumber;

    public LineNumberTableEntry(int startPc, int lineNumber) {
        this.startPc = startPc;
        this.lineNumber = lineNumber;
    }
}
