package org.jjvm.runtime;

public class OperandStack {
    private int next;
    private Slot[] slots;

    public OperandStack(int maxStack) throws Exception {
        if (maxStack <= 0) {
            throw new Exception("max Stack must be greater than 0!");
        }

        next = 0;
        slots = new Slot[maxStack];
        for (int i = 0; i < maxStack; i ++) {
            slots[i] = new Slot();
        }
    }

    public void pushInt(int value) {
        slots[next].num = value;
        next++;
    }

    public int popInt() {
        next--;
        return slots[next].num;
    }

    public void pushFloat(float value) {
        int bits = Float.floatToIntBits(value);
        slots[next].num = bits;
        next++;
    }

    public float popFloat() {
        next--;
        int bits = slots[next].num;
        return Float.intBitsToFloat(bits);
    }

    public void pushLong(long value) {
        slots[next].num = (int)value;
        slots[next+1].num = (int)(value >> 32);
        next += 2;
    }

    public long popLong() {
        next -= 2;
        int low = (int)slots[next].num;
        int high = (int)slots[next+1].num;
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
