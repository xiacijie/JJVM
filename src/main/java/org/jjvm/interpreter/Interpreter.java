package org.jjvm.interpreter;

import org.jjvm.classfile.MemberInfo;
import org.jjvm.classfile.attributes.CodeAttribute;
import org.jjvm.instruction.Factory;
import org.jjvm.instruction.Instruction;
import org.jjvm.instruction.base.BytecodeReader;
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
        loop(thread, code);
    }

    public void loop(Thread thread, byte[] code) {
        Frame frame = thread.popFrame();
        BytecodeReader reader = new BytecodeReader();
        while (true) {
            int pc = frame.nextPC;
            thread.pc = pc;

            reader.reset(code, pc);
            int opcode = Byte.toUnsignedInt(reader.readUint8());
            Instruction instruction = Factory.createInstruction(opcode);
            instruction.fetchOperands(reader);
            frame.nextPC = reader.pc;

            System.out.println("pc: " + pc + " inst: " + instruction.getClass().getName());
            instruction.execute(frame);
        }
    }
}
