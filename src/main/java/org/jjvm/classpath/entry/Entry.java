package org.jjvm.classpath.entry;

import java.io.IOException;

public interface Entry {
    public String toString();
    public ReadClassResult readClass(String className) throws IOException;
}
