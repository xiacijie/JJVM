package org.jjvm.classpath;

import org.jjvm.classpath.entry.Entry;
import org.jjvm.classpath.entry.EntryFactory;
import org.jjvm.classpath.entry.ReadClassResult;
import org.jjvm.classpath.entry.WildcardEntry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class ClassPath {
    public Entry bootClassPath;
    public Entry extClassPath;
    public Entry userClassPath;

    public static ClassPath parse(String jreOption, String cpOption) throws IOException {
        ClassPath classPath = new ClassPath();
        classPath.parseBootAndExtClassPath(jreOption);
        classPath.parseUserClassPath(cpOption);
        return classPath;
    }

    private void parseBootAndExtClassPath(String jreOption) throws IOException {
        String jreDir = getJreDir(jreOption);
        String jreLibPath = Paths.get(jreDir, "lib", "*").toString();
        bootClassPath = new WildcardEntry(jreLibPath);

        String jreExtPath = Paths.get(jreDir, "lib", "ext", "*").toString();
        extClassPath = new WildcardEntry(jreExtPath);
    }

    private void parseUserClassPath(String cpOption) throws IOException {
        if (cpOption.isEmpty()) {
            cpOption = ".";
        }

        userClassPath = EntryFactory.create(cpOption);
    }

    private String getJreDir(String jreOption) throws IOException {
        if (! jreOption.isEmpty() && exists(jreOption)) {
            return jreOption;
        }

        if (exists("./jre")) {
            return "./jre";
        }

        String javaHome = System.getenv("JAVA_HOME");
        if (!javaHome.isEmpty()) {
            return Paths.get(javaHome, "jre").toString();
        }

        throw new IOException("Cannot find jre folder!");
    }

    private Boolean exists(String path) {
        File file = new File(path);
        return file.exists();
    }

    public ReadClassResult readClass(String className) throws IOException {
        className += ".class";
        ReadClassResult result = bootClassPath.readClass(className);
    }

    public String toString() {

    }

}