package org.jjvm.classpath.entry;

import java.io.IOException;

public class WildcardEntry extends CompositeEntry{

    public WildcardEntry(String pathList) throws IOException {
        super(pathList);
    }
}
