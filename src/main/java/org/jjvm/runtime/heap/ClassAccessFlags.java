package org.jjvm.runtime.heap;

public class ClassAccessFlags {
    public final short ACC_PUBLIC = 0x0001;
    public final short ACC_PRIVATE = 0x0002;
    public final short ACC_PROTECTED = 0x0004;
    public final short ACC_STATIC = 0x0008;
    public final short ACC_FINAL = 0x0010;
    public final short ACC_SUPER = 0x0020;
    public final short ACC_SYNCHRONIZED = 0x0020;
    public final short ACC_VOLATILE = 0x0040;
    public final short ACC_BRIDGE = 0x0040;
    public final short ACC_TRANSIENT = 0x0080;
    public final short ACC_VARARGS = 0x0080;
    public final short ACC_NATIVE = 0x0100;
    public final short ACC_INTERFACE = 0x0200;
    public final short ACC_ABSTRACT = 0x0400;
    public final short ACC_STRICT = 0x0800;
    public final short ACC_SYNTHETIC = 0x1000;
    public final short ACC_ANNOTATION = 0x2000;
    public final short ACC_ENUM = 0x4000;

}
