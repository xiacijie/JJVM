package org.jjvm.classpath.entry;

public interface Entry {
    public String toString();
    public ReadClassResult readClass(String className);
}
