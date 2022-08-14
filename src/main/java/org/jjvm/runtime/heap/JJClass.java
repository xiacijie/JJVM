package org.jjvm.runtime.heap;

import org.jjvm.classfile.ClassFileConstantPool;

public class JJClass {
    public short accessFlags;
    public String name;
    public String superClassName;
    public String[] interfaceNames;
    public ClassFileConstantPool constantPool;
}
