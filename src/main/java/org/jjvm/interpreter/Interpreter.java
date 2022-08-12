package org.jjvm.interpreter;

import org.jjvm.classfile.MemberInfo;
import org.jjvm.classfile.attributes.CodeAttribute;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.Thread;

public class Interpreter {
    public void interpret(MemberInfo methodInfo) {
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        int maxLocals = codeAttribute.getMaxLocals();
        int maxStack = codeAttribute.getMaxStack();
        byte[] code = codeAttribute.getCode();
        Thread thread = new Thread();
        Frame frame = new Frame(maxLocals, maxStack);
        thread.pushFrame(frame);
        
    }
}
