package org.jjvm.classfile.attributes;

public class ExceptionTableEntry {
    public int startPc;
    public int endPc;
    public int handlerPc;
    public int catchType;

    public ExceptionTableEntry(int startPc, int endPc, int handlerPc, int catchType) {
        this.startPc = startPc;
        this.endPc = endPc;
        this.handlerPc = handlerPc;
        this.catchType = catchType;
    }
}
