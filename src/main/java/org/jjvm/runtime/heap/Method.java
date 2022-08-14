package org.jjvm.runtime.heap;

import org.jjvm.classfile.MemberInfo;
import org.jjvm.classfile.attributes.CodeAttribute;

public class Method extends ClassMember{
    public int maxStack;
    public int maxLocals;
    public byte[] code;

    public Method(MemberInfo memberInfo) {
        super(memberInfo);
        CodeAttribute codeAttribute = memberInfo.getCodeAttribute();
        if (codeAttribute != null) {
            maxStack = codeAttribute.getMaxStack();
            maxLocals = codeAttribute.getMaxLocals();
            code = codeAttribute.getCode();
        }
    }

    public static Method[] createMethods(JJClass klass, MemberInfo[] members) {
        Method[] methods = new Method[members.length];
        for (int i = 0; i < members.length; i ++) {
            methods[i] = new Method(members[i]);
            methods[i].klass = klass;
        }
        return methods;
    }
    
}
