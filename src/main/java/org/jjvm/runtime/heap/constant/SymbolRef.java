package org.jjvm.runtime.heap.constant;

import org.jjvm.runtime.heap.JJClass;
import org.jjvm.runtime.heap.RuntimeConstantPool;

public class SymbolRef implements Constant {
    public RuntimeConstantPool cp;
    public String className;
    public JJClass klass;

    
}
