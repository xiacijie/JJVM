package org.jjvm.classfile;

public class MemberInfo {
    public ConstantPool constantPool;
    public short accessFlags;
    public short nameIndex;
    public short descriptorIndex;
    public AttributeInfo[] attributes;

    public String getName() {
        return constantPool.getUtf8(nameIndex);
    }

    public String getDescriptor() {
        return constantPool.getUtf8(descriptorIndex);
    }

    static public MemberInfo[] readMembers(ClassReader classReader, ConstantPool constantPool) {
        int memberCount = Short.toUnsignedInt(classReader.readUint16());
        MemberInfo[] members = new MemberInfo[memberCount];
        for (int i = 0; i < memberCount; i ++) {
            members[i] = readMember(classReader, constantPool);
        }
        return members;
    }

    static public MemberInfo readMember(ClassReader classReader, ConstantPool constantPool) {
        MemberInfo member = new MemberInfo();
        member.constantPool = constantPool;
        member.accessFlags = classReader.readUint16();
        member.nameIndex = classReader.readUint16();
        member.descriptorIndex = classReader.readUint16();
        member.attributes = readAttributes(classReader, constantPool);
    }
}
