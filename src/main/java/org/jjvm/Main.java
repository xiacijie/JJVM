package org.jjvm;

import org.apache.commons.cli.*;
import org.jjvm.classpath.ClassPath;
import org.jjvm.classpath.entry.ReadClassResult;
import org.jjvm.cmd.CMD;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws ParseException, IOException {
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

    public static void startJVM(CMD cmd) throws IOException {
        System.out.println("Start JVM ..." + cmd.XjreOption + " " + cmd.cpOption);
        ClassPath classPath = ClassPath.parse(cmd.XjreOption, cmd.cpOption);
        System.out.println("classpath: " + classPath.toString() + " class: " + cmd.klass + " args: " + cmd.args);
        String className = cmd.klass.replace(".", "/");
        ReadClassResult result = classPath.readClass(className);
        if (!result.valid) {
            System.out.println("Could not find or load main class " + cmd.klass);
            return;
        }

        System.out.println("class data: " + Arrays.toString(result.bytes));
    }
}
