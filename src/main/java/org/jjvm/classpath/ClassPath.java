package org.jjvm.classpath;

import org.jjvm.classpath.entry.Entry;
import org.jjvm.classpath.entry.EntryFactory;
import org.jjvm.classpath.entry.ReadClassResult;
import org.jjvm.classpath.entry.WildcardEntry;
import org.jjvm.exception.JJException;

import java.io.File;
import java.nio.file.Paths;

public class ClassPath {
    public Entry bootClassPath;
    public Entry extClassPath;
    public Entry userClassPath;

    public static ClassPath parse(String jreOption, String cpOption)  {
        ClassPath classPath = new ClassPath();
        classPath.parseBootAndExtClassPath(jreOption);
        classPath.parseUserClassPath(cpOption);
        return classPath;
    }

    private void parseBootAndExtClassPath(String jreOption)  {
        String jreDir = getJreDir(jreOption);
        String jreLibPath = jreDir + File.separator + "lib" + File.separator + "*";
        bootClassPath = new WildcardEntry(jreLibPath);
        String jreExtPath = jreDir + File.separator + "lib" + File.separator + "ext" + File.separator + "*";
        extClassPath = new WildcardEntry(jreExtPath);
    }

    private void parseUserClassPath(String cpOption)  {
        if (cpOption.isEmpty()) {
            cpOption = ".";
        }

        userClassPath = EntryFactory.create(cpOption);
    }

    private String getJreDir(String jreOption)  {
        if (jreOption != null && exists(jreOption)) {
            return jreOption;
        }

        if (exists("./jre")) {
            return "./jre";
        }

        String javaHome = System.getenv("JAVA_HOME");
        if (javaHome != null && !javaHome.isEmpty()) {
            return Paths.get(javaHome, "jre").toString();
        }
        JJException.throwException("Cannot find jre folder!");
        return null;
    }

    private Boolean exists(String path) {
        File file = new File(path);
        return file.exists();
    }

    public ReadClassResult readClass(String className) {
        className += ".class";
        ReadClassResult result = bootClassPath.readClass(className);
        if (result.valid) {
            return result;
        }

        ReadClassResult result1 = extClassPath.readClass(className);
        if (result1.valid) {
            return result1;
        }

        return userClassPath.readClass(className);
    }

    public String toString() {
        return userClassPath.toString();
    }

}
