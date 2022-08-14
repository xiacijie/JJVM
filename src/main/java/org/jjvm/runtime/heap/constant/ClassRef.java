package org.jjvm.runtime.heap.constant;

import org.jjvm.classfile.constants.ConstantClassInfo;
import org.jjvm.runtime.heap.RuntimeConstantPool;

public class ClassRef extends SymbolRef {
    public ClassRef(RuntimeConstantPool cp, ConstantClassInfo classInfo) {
        this.cp = cp;
        className = classInfo.getName();
    }
}
