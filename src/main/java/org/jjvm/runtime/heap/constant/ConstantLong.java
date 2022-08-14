package org.jjvm.runtime.heap.constant;

public class ConstantLong implements Constant {
    public long value;
    public ConstantLong(long value) {
        this.value = value;
    }
}
