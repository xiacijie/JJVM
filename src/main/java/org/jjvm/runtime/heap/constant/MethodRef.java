package org.jjvm.runtime.heap.constant;

import org.jjvm.classfile.constants.ConstantMethodrefInfo;
import org.jjvm.runtime.heap.RuntimeConstantPool;

public class MethodRef extends MemberRef {

    public MethodRef(RuntimeConstantPool cp, ConstantMethodrefInfo methodRefInfo) {
        super(methodRefInfo);
        this.cp = cp;
    }
    
}
