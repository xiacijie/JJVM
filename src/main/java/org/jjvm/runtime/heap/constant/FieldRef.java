package org.jjvm.runtime.heap.constant;

import org.jjvm.classfile.constants.ConstantFieldrefInfo;
import org.jjvm.runtime.heap.Field;
import org.jjvm.runtime.heap.RuntimeConstantPool;

public class FieldRef extends MemberRef{
    public Field field;

    public FieldRef(RuntimeConstantPool cp, ConstantFieldrefInfo constantFieldrefInfo) {
        super(constantFieldrefInfo);
        this.cp = cp;
    }
    
}
