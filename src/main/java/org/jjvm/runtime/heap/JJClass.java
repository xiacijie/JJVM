package org.jjvm.runtime.heap;

import org.jjvm.classfile.ClassFile;
import org.jjvm.classfile.ClassFileConstantPool;
import org.jjvm.runtime.Slot;

public class JJClass {
    public short accessFlags;
    public String name;
    public String superClassName;
    public String[] interfaceNames;
    public RuntimeConstantPool constantPool;
    public Field[] fields;
    public Method[] methods;
    public ClassLoader classLoader;
    public JJClass superClass;
    public JJClass[] interfaces;
    public int instanceSlotCount;
    public int staticSlotCount;
    public Slot[] staticVars;

    public JJClass(ClassFile classFile) {
        accessFlags =  classFile.accessFlags;
        name = classFile.getClassName();
        superClassName = classFile.getSuperClassName();
        interfaceNames = classFile.getInterfaceNames();
        constantPool = new RuntimeConstantPool(this, classFile.constantPool)
        fields = Field.createFields(this, classFile.fields);
        methods = Method.createMethods(this, classFile.methods);
    }
}
