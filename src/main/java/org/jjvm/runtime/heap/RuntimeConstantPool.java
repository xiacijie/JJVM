package org.jjvm.runtime.heap;

import org.jjvm.classfile.ClassFileConstantPool;
import org.jjvm.classfile.constants.ConstantInfo;
import org.jjvm.classfile.constants.ConstantIntegerInfo;
import org.jjvm.exception.JJException;

public class RuntimeConstantPool {
    public JJClass kClass;
    public Constant[] constants;

    public RuntimeConstantPool(JJClass klass, ClassFileConstantPool classFileConstantPool) {
        int cpSize = classFileConstantPool.size();
        constants = new Constant[cpSize];
        for (int i = 1; i < cpSize; i ++) {
            ConstantInfo constantInfo = classFileConstantPool.getConstantInfo(i);
            if (constantInfo instanceof ConstantIntegerInfo) {
                ConstantIntegerInfo constantIntegerInfo = (ConstantIntegerInfo)constantInfo;
            }
        }
    }

    public Constant getConstant(int index) {
        Constant constant = null;
        if (index >= 0 && index < constants.length) {
            constant = constants[index];
        }

        if (constant != null) {
            return constant;
        }
        JJException.throwException("No constant at index: " + index);
        return null;
    }
}
