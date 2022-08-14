package org.jjvm.runtime.heap;

import org.jjvm.classfile.MemberInfo;

public class ClassMember {
    public short accessFlags;
    public String name;
    public String descriptor;
    public JJClass klass;

    public ClassMember(MemberInfo memberInfo) {
        this.accessFlags = memberInfo.accessFlags;
        this.name = memberInfo.getName();
        this.descriptor = memberInfo.getDescriptor();
    }
}
