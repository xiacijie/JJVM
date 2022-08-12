package org.jjvm.test;

import org.apache.commons.cli.*;
import org.jjvm.classfile.ClassFile;
import org.jjvm.classfile.MemberInfo;
import org.jjvm.classpath.ClassPath;
import org.jjvm.classpath.entry.ReadClassResult;
import org.jjvm.cmd.CMD;
import org.jjvm.runtime.Frame;
import org.jjvm.runtime.LocalVars;
import org.jjvm.runtime.OperandStack;

import java.io.IOException;
import java.util.Arrays;


public class TestRuntime {
    public static void main(String[] args)  {
       startJVM(null);
    }

    private static void startJVM(CMD cmd)  {
        Frame frame = new Frame(100, 100);
        testLocalVars(frame.localVars);
        testOperandStack(frame.operandStack);
    }

    private static void testLocalVars(LocalVars localVars) {
        localVars.setInt(0, 100);
        localVars.setInt(1, -100);
        localVars.setLong(2, 2997924580L);
        localVars.setLong(4, -2997924580L);
        localVars.setFloat(6, 3.1415926F);
        localVars.setDouble(7, 2.71828182845);
        localVars.setRef(9, null);
        System.out.println(localVars.getInt(0));
        System.out.println(localVars.getInt(1));
        System.out.println(localVars.getLong(2));
        System.out.println(localVars.getLong(4));
        System.out.println(localVars.getFloat(6));
        System.out.println(localVars.getDouble(7));
        System.out.println(localVars.getRef(9));
    }

    private static void testOperandStack(OperandStack ops) {
        ops.pushInt(100);
        ops.pushInt(-100);
        ops.pushLong(2997924580L);
        ops.pushLong(-2997924580L);
        ops.pushFloat(3.1415926F);
        ops.pushDouble(2.71828182845);
        ops.pushRef(null);
        System.out.println(ops.popRef());
        System.out.println(ops.popDouble());
        System.out.println(ops.popFloat());
        System.out.println(ops.popLong());
        System.out.println(ops.popLong());
        System.out.println(ops.popInt());
        System.out.println(ops.popInt());
    }


  
}
