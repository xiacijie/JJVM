package org.jjvm.runtime;

public class LocalVars {
    private Slot[] slots;

    public LocalVars(int maxLocals) throws Exception {
        if (maxLocals <= 0) {
            throw new Exception("max locals must be great than 0!");
        }

        slots = new Slot[maxLocals];
        for (int i = 0; i < maxLocals; i ++) {
            slots[i] = new Slot();
        }
    }

    public void setInt(int index, int value) {
        slots[index].num = value;
    }

    public int getInt(int index) {
        return slots[index].num;
    }

    public void setFloat(int index, float value) {
        int bits = Float.floatToIntBits(value);
        slots[index].num = bits;
    }

    public float getFloat(int index) {
        int bits = slots[index].num;
        return Float.intBitsToFloat(bits);
    }

    public void setLong(int index, long value) {
        slots[index].num = (int)value;
        slots[index+1].num = (int)(value >> 32);
    }

    public long getLong(int index) {
        int low = slots[index].num;
        int high = slots[index + 1].num;
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

    public void setRef(int index, Object ref) {
        slots[index].ref = ref;
    }

    public Object getRef(int index) {
        return slots[index].ref;
    }



}
