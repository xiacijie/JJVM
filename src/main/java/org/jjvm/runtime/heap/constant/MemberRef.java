package org.jjvm.runtime.heap.constant;

import org.jjvm.classfile.constants.ConstantMemberrefInfo;
import org.jjvm.util.Tuple;

public class MemberRef extends SymbolRef {
    public String name;
    public String descriptor;

    public MemberRef(ConstantMemberrefInfo memberrefInfo) {
        className = memberrefInfo.getClassName();
        Tuple<String, String> nameAndDescriptor = memberrefInfo.getNameAndDescriptor();
        name = nameAndDescriptor.first;
        descriptor = nameAndDescriptor.second;
    }
}
