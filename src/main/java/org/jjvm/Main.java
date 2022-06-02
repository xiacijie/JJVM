package org.jjvm;

import org.apache.commons.cli.*;
import org.jjvm.classfile.ClassFile;
import org.jjvm.classfile.MemberInfo;
import org.jjvm.classpath.ClassPath;
import org.jjvm.classpath.entry.ReadClassResult;
import org.jjvm.cmd.CMD;

import java.io.IOException;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception {
        CMD cmd = CMD.parseCommandLineArguments(args);
        if (cmd.versionFlag) {
            System.out.println("version 0.0.1");
        }
        else if (cmd.helpFlag || cmd.klass.equals("")) {
            CMD.printCommandLineUsage();
        }
        else {
            startJVM(cmd);
        }
    }

    private static void startJVM(CMD cmd) throws Exception {
        System.out.println("Start JVM ...");
        ClassPath classPath = ClassPath.parse(cmd.XjreOption, cmd.cpOption);
        String className = cmd.klass.replace(".", "/");
        ClassFile classFile = loadClass(className, classPath);
        System.out.println(cmd.klass);
        printClassInfo(classFile);
    }

    private static ClassFile loadClass(String className, ClassPath classPath) throws Exception {
        ReadClassResult readClassResult = classPath.readClass(className);
        if (!readClassResult.valid) {
            throw new IOException("load class invalid result!");
        }

        ClassFile classFile = ClassFile.parse(readClassResult.bytes);
        return classFile;
    }

    private static void printClassInfo(ClassFile classFile) throws Exception {
        System.out.println("version: " + classFile.majorVersion + "." + classFile.minorVersion);
        System.out.println("constants count: " + classFile.constantPool.size());
        System.out.println("this class: " + classFile.getClassName());
        System.out.println("super class: " + classFile.getSuperClassName());
        System.out.print("interfaces: ");
        for (String intf: classFile.getInterfaceNames()) {
            System.out.println(intf);
        }
        System.out.println("fields count: " + classFile.fields.length);
        System.out.println("methods count: " + classFile.methods.length);
        for (MemberInfo method: classFile.methods) {
            System.out.println(method.getName());
        }
    }
}
