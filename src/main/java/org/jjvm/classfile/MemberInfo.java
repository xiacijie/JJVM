package org.jjvm.classfile;

import org.jjvm.classfile.attributes.AttributeInfo;
import org.jjvm.classfile.attributes.CodeAttribute;

public class MemberInfo {
    public ClassFileConstantPool constantPool;
    public short accessFlags;
    public short nameIndex;
    public short descriptorIndex;
    public AttributeInfo[] attributes;

    public String getName()  {
        return constantPool.getUtf8(nameIndex);
    }

    public String getDescriptor()  {
        return constantPool.getUtf8(descriptorIndex);
    }

    public CodeAttribute getCodeAttribute() {
        for (AttributeInfo attr : attributes) {
            if (attr instanceof CodeAttribute) {
                return (CodeAttribute)attr;
            }
        }
        // System.out.println("Does not find code attribute!");
        // System.exit(1);
        return null;
    }

    static public MemberInfo[] readMembers(ClassReader classReader, ClassFileConstantPool constantPool)  {
        int memberCount = Short.toUnsignedInt(classReader.readUint16());
        MemberInfo[] members = new MemberInfo[memberCount];
        for (int i = 0; i < memberCount; i ++) {
            members[i] = readMember(classReader, constantPool);
        }
        return members;
    }

    static public MemberInfo readMember(ClassReader classReader, ClassFileConstantPool constantPool)  {
        MemberInfo member = new MemberInfo();
        member.constantPool = constantPool;
        member.accessFlags = classReader.readUint16();
        member.nameIndex = classReader.readUint16();
        member.descriptorIndex = classReader.readUint16();
        member.attributes = AttributeInfo.readAttributes(classReader, constantPool);
        return member;
    }


}
