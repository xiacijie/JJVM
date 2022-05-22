package org.jjvm.classpath.entry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DirEntry implements Entry {
    public String absoluteDirPath;

    public DirEntry(String relativePath) throws IOException {
        File f = new File(relativePath);
        if (! f.exists()) {
            throw new IOException("path: " + relativePath + " does not exist!");
        }
        absoluteDirPath =  f.getCanonicalPath();
    }

    @Override
    public ReadClassResult readClass(String className) throws IOException {
        String fileName = Paths.get(absoluteDirPath, className).toString();
        ReadClassResult result = new ReadClassResult();
        result.entry = this;
        result.bytes = Files.readAllBytes(Paths.get(fileName));
        return result;
    }

    @Override
    public String toString() {
        return absoluteDirPath;
    }
}
