package org.jjvm.runtime.heap.constant;

public class ConstantString implements Constant{
    public String value;
    public ConstantString(String value) {
        this.value = value;
    }
}
