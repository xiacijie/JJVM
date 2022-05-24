package org.jjvm;

import org.apache.commons.cli.*;
import org.jjvm.cmd.CMD;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) throws ParseException {
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

    public static void startJVM(CMD cmd) {
        System.out.println("Start JVM ...");
        for (String arg : cmd.args) {
            System.out.println(arg);
        }
    }
}
