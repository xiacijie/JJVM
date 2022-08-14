package org.jjvm.runtime.heap.constant;

public class ConstantDouble implements Constant {
    public double value;
    public ConstantDouble(double value) {
        this.value = value;
    }
}
