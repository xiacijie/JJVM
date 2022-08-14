package org.jjvm.runtime.heap;

import org.jjvm.classfile.ClassFileConstantPool;
import org.jjvm.classfile.constants.ConstantClassInfo;
import org.jjvm.classfile.constants.ConstantDoubleInfo;
import org.jjvm.classfile.constants.ConstantFieldrefInfo;
import org.jjvm.classfile.constants.ConstantFloatInfo;
import org.jjvm.classfile.constants.ConstantInfo;
import org.jjvm.classfile.constants.ConstantIntegerInfo;
import org.jjvm.classfile.constants.ConstantInterfaceMethodrefInfo;
import org.jjvm.classfile.constants.ConstantLongInfo;
import org.jjvm.classfile.constants.ConstantMethodrefInfo;
import org.jjvm.classfile.constants.ConstantStringInfo;
import org.jjvm.exception.JJException;
import org.jjvm.runtime.heap.constant.ClassRef;
import org.jjvm.runtime.heap.constant.Constant;
import org.jjvm.runtime.heap.constant.ConstantDouble;
import org.jjvm.runtime.heap.constant.ConstantFloat;
import org.jjvm.runtime.heap.constant.ConstantInt;
import org.jjvm.runtime.heap.constant.ConstantLong;
import org.jjvm.runtime.heap.constant.ConstantString;
import org.jjvm.runtime.heap.constant.FieldRef;
import org.jjvm.runtime.heap.constant.InterfaceMethodRef;
import org.jjvm.runtime.heap.constant.MethodRef;

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
                constants[i] = new ConstantInt(constantIntegerInfo.getValue());
            }
            else if (constantInfo instanceof ConstantFloatInfo) {
                ConstantFloatInfo constantFloatInfo = (ConstantFloatInfo)constantInfo;
                constants[i] = new ConstantFloat(constantFloatInfo.getValue());
            }
            else if (constantInfo instanceof ConstantLongInfo) {
                ConstantLongInfo constantLongInfo = (ConstantLongInfo)constantInfo;
                constants[i] = new ConstantLong(constantLongInfo.getValue());
                i++;
            }
            else if (constantInfo instanceof ConstantDoubleInfo) {
                ConstantDoubleInfo constantDoubleInfo = (ConstantDoubleInfo)constantInfo;
                constants[i] = new ConstantDouble(constantDoubleInfo.getValue());
                i++;
            }
            else if (constantInfo instanceof ConstantStringInfo) {
                ConstantStringInfo constantStringInfo = (ConstantStringInfo)constantInfo;
                constants[i] = new ConstantString(constantStringInfo.getString());
            }
            else if (constantInfo instanceof ConstantClassInfo) {
                ConstantClassInfo constantClassInfo = (ConstantClassInfo)constantInfo;
                constants[i] = new ClassRef(this, constantClassInfo);
            }
            else if (constantInfo instanceof ConstantFieldrefInfo) {
                ConstantFieldrefInfo constantFieldrefInfo = (ConstantFieldrefInfo)constantInfo;
                constants[i] = new FieldRef(this, constantFieldrefInfo);
            }
            else if (constantInfo instanceof ConstantMethodrefInfo) {
                ConstantMethodrefInfo constantMethodrefInfo = (ConstantMethodrefInfo)constantInfo;
                constants[i] = new MethodRef(this, constantMethodrefInfo);
            }
            else if (constantInfo instanceof ConstantInterfaceMethodrefInfo) {
                ConstantInterfaceMethodrefInfo constantInterfaceMethodrefInfo = (ConstantInterfaceMethodrefInfo)constantInfo;
                constants[i] = new InterfaceMethodRef(this, constantInterfaceMethodrefInfo);
            }
            else {
                JJException.throwException("unknown constant info!");
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
