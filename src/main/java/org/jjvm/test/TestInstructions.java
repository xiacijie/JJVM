package org.jjvm.test;

import org.jjvm.classfile.ClassFile;
import org.jjvm.classfile.MemberInfo;
import org.jjvm.classpath.ClassPath;
import org.jjvm.classpath.entry.ReadClassResult;
import org.jjvm.cmd.CMD;
import org.jjvm.exception.JJException;
import org.jjvm.interpreter.Interpreter;

public class TestInstructions {
    public static void main(String[] args) {
        CMD cmd = CMD.parseCommandLineArguments(args);
        startJVM(cmd);
    }

    static private void startJVM(CMD cmd) {
        ClassPath cp = ClassPath.parse(cmd.XjreOption, cmd.cpOption);
        System.out.println(cmd.klass);
        ClassFile classFile = loadClass(cmd.klass, cp);
        MemberInfo mainMethod = getMainMethod(classFile);
        Interpreter interpreter = new Interpreter();
        interpreter.interpret(mainMethod);
    }

    static private ClassFile loadClass(String className, ClassPath cp) {
        ReadClassResult result = cp.readClass(className);
        if (!result.valid) {
            JJException.throwException("Invalid read class result!");
        }

        ClassFile classFile = ClassFile.parse(result.bytes);
        return classFile;

    }

    static private MemberInfo getMainMethod(ClassFile classFile) {
        for ( MemberInfo memberInfo : classFile.methods) {
            if (memberInfo.getName().equals("main") && memberInfo.getDescriptor().equals("([Ljava/lang/String;)V")) {
                return memberInfo;
            }
        }
        return null;
    }
}
