package org.jjvm.cmd;

import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The class for command line options
 */
public class CMD {
    static class JavaCMDOption {
        public static final String HELP_FULL = "help";
        public static final String HELP_SHORT = "?";
        public static final String VERSION = "version";
        public static final String CLASSPATH_FULL = "classpath";
        public static final String JRE = "Xjre";
        public static final String CLASSPATH_SHORT = "cp";
    }

    public boolean helpFlag = false; // print help message
    public boolean versionFlag = false; // print version info
    public String cpOption = "";
    public String klass = "";
    public String XjreOption = "";
    public ArrayList<String> args = new ArrayList<>();

    public static Options getCommandLineOptions() {
        Options options = new Options();
        options.addOption(JavaCMDOption.HELP_FULL,"print help message");
        options.addOption(JavaCMDOption.HELP_SHORT, "print help message");
        options.addOption(JavaCMDOption.VERSION, "print version and exit");
        options.addOption(JavaCMDOption.JRE, "path to jre");
        options.addOption(JavaCMDOption.CLASSPATH_FULL, "classpath");
        options.addOption(JavaCMDOption.CLASSPATH_SHORT, "classpath");
        return options;
    }

    public static void printCommandLineUsage() {
        HelpFormatter formatter = new HelpFormatter();
        String header = "JJVM \n\n";
        String footer = "\nAuthor: Cijie Xia";
        formatter.printHelp("jjava", header, getCommandLineOptions(), footer, true);
    }

    public static CMD parseCommandLineArguments(String[] args) throws ParseException {
        Options options = getCommandLineOptions();

        CommandLineParser parser = new DefaultParser();
        CommandLine c = parser.parse(options, args);

        CMD cmd = new CMD();
        cmd.helpFlag = c.hasOption(JavaCMDOption.HELP_FULL) || c.hasOption(JavaCMDOption.HELP_SHORT);
        cmd.versionFlag = c.hasOption(JavaCMDOption.VERSION);

        if (c.hasOption(JavaCMDOption.CLASSPATH_FULL)) {
            cmd.cpOption = c.getOptionValue(JavaCMDOption.CLASSPATH_FULL);
        }
        else if (c.hasOption(JavaCMDOption.CLASSPATH_SHORT)){
            cmd.cpOption = c.getOptionValue(JavaCMDOption.CLASSPATH_SHORT);
        }

        if (c.hasOption(JavaCMDOption.JRE)) {
            cmd.XjreOption = c.getOptionValue(JavaCMDOption.JRE);
        }

        if(c.getArgs().length > 0) {
            cmd.klass = c.getArgs()[0];
            cmd.args.addAll(Arrays.asList(c.getArgs()));
        }


        return cmd;
    }
}
