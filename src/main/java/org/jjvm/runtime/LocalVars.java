package org.jjvm.runtime;

import org.jjvm.exception.JJException;
import org.jjvm.runtime.heap.JJObject;

public class LocalVars {
    private Slot[] slots;

    public LocalVars(int maxLocals)  {
        if (maxLocals <= 0) {
            JJException.throwException("max locals must be great than 0!");
        }

        slots = new Slot[maxLocals];
        for (int i = 0; i < maxLocals; i ++) {
            slots[i] = new Slot();
        }
    }

    public void setInt(int index, int value) {
        slots[index].bits = value;
    }

    public int getInt(int index) {
        return slots[index].bits;
    }

    public void setFloat(int index, float value) {
        int bits = Float.floatToIntBits(value);
        slots[index].bits = bits;
    }

    public float getFloat(int index) {
        int bits = slots[index].bits;
        return Float.intBitsToFloat(bits);
    }

    public void setLong(int index, long value) {
        slots[index].bits = (int)value;
        slots[index+1].bits = (int)(value >> 32);
    }

    public long getLong(int index) {
        int low = slots[index].bits;
        int high = slots[index + 1].bits;
        return ((long)high << 32) | ((long)low & 0xFFFFFFFFL);
    }

    public void setDouble(int index, double value) {
        long bits = Double.doubleToLongBits(value);
        setLong(index, bits);
    }

    public double getDouble(int index) {
        long bits = getLong(index);
        return Double.longBitsToDouble(bits);
    }

    public void setRef(int index, JJObject ref) {
        slots[index].ref = ref;
    }

    public JJObject getRef(int index) {
        return slots[index].ref;
    }



}
