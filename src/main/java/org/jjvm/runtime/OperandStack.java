package org.jjvm.runtime;

import org.jjvm.exception.JJException;

public class OperandStack {
    private int next;
    private Slot[] slots;

    public OperandStack(int maxStack)  {
        if (maxStack <= 0) {
            JJException.throwException("max Stack must be greater than 0!");
        }

        next = 0;
        slots = new Slot[maxStack];
        for (int i = 0; i < maxStack; i ++) {
            slots[i] = new Slot();
        }
    }

    public void pushInt(int value) {
        slots[next].bits = value;
        next++;
    }

    public int popInt() {
        next--;
        return slots[next].bits;
    }

    public void pushFloat(float value) {
        int bits = Float.floatToIntBits(value);
        slots[next].bits = bits;
        next++;
    }

    public float popFloat() {
        next--;
        int bits = slots[next].bits;
        return Float.intBitsToFloat(bits);
    }

    public void pushLong(long value) {
        slots[next].bits = (int)value;
        slots[next+1].bits = (int)(value >> 32);
        next += 2;
    }

    public long popLong() {
        next -= 2;
        int low = (int)slots[next].bits;
        int high = (int)slots[next+1].bits;
        return ((long)high << 32) | ((long)low & 0xFFFFFFFFL);
    }

    public void pushDouble(double value) {
        long bits = Double.doubleToLongBits(value);
        pushLong(bits);
    }

    public double popDouble() {
        long bits = popLong();
        return Double.longBitsToDouble(bits);
    }

    public void pushRef(Object ref) {
        slots[next].ref = ref;
        next++;
    }

    public Object popRef() {
        next--;
        Object ref = slots[next].ref;
        slots[next].ref = null;
        return ref;
    }

    public void pushSlot(Slot slot) {
        slots[next] = slot;
        next++;
    }

    public Slot popSlot() {
        next--;
        return slots[next];
    }
}
