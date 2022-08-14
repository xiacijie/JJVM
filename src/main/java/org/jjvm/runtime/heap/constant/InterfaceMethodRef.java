package org.jjvm.runtime.heap.constant;

import org.jjvm.classfile.constants.ConstantInterfaceMethodrefInfo;
import org.jjvm.runtime.heap.RuntimeConstantPool;

public class InterfaceMethodRef extends MemberRef {

    public InterfaceMethodRef(RuntimeConstantPool cp, ConstantInterfaceMethodrefInfo constantInterfaceMethodrefInfo) {
        super(constantInterfaceMethodrefInfo);
        this.cp = cp;
    }
    
}
