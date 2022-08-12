package org.jjvm.classpath.entry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.jjvm.exception.JJException;

public class DirEntry implements Entry {
    public String absoluteDirPath;

    public DirEntry(String relativePath)  {
        File f = new File(relativePath);
        if (! f.exists()) {
            JJException.throwException("path: " + relativePath + " does not exist!");
        }
        try {
            absoluteDirPath =  f.getCanonicalPath();
        }
        catch (Exception e) {
            JJException.throwException(e.getMessage());
        }
        
    }

    @Override
    public ReadClassResult readClass(String className) {
        ReadClassResult result = new ReadClassResult();
        try {
            String fileName = Paths.get(absoluteDirPath, className).toString();
            result.bytes = Files.readAllBytes(Paths.get(fileName));
            result.entry = this;
            result.valid = true;
        } catch (IOException e) {
            result.valid = false;
        }
        return result;
    }

    @Override
    public String toString() {
        return absoluteDirPath;
    }
}
