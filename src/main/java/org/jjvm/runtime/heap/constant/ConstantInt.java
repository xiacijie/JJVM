package org.jjvm.runtime.heap.constant;

public class ConstantInt implements Constant {
    public int value;

    public ConstantInt(int value) {
        this.value = value;
    }
}
