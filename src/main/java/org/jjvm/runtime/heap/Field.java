package org.jjvm.runtime.heap;

import org.jjvm.classfile.MemberInfo;

public class Field extends ClassMember {

    public Field(MemberInfo memberInfo) {
        super(memberInfo);
    }

    static public Field[] createFields(JJClass klass, MemberInfo[] members) {
        Field[] fields = new Field[members.length];
        for (int i = 0; i < members.length; i ++) {
            fields[i] = new Field(members[i]);
            fields[i].klass = klass;
        }

        return fields;
    }
    
}
