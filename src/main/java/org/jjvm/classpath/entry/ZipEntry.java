package org.jjvm.classpath.entry;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipFile;

import org.jjvm.exception.JJException;

public class ZipEntry implements Entry {
    public String absoluteZipPath;

    public ZipEntry(String path)  {
        File f = new File(path);
        if (! f.exists()) {
            JJException.throwException("path: " + path + " does not exist!");
        }
        try {
            absoluteZipPath =  f.getCanonicalPath();
        }
        catch (Exception e) {
            JJException.throwException(e.getMessage());
        }
        
    }

    @Override
    public ReadClassResult readClass(String className) {
        try {
            try (ZipFile zipFile = new ZipFile(absoluteZipPath)) {
                Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile.entries();
                ReadClassResult result = new ReadClassResult();
                while (entries.hasMoreElements()) {
                    java.util.zip.ZipEntry entry = entries.nextElement();
                    if (entry.getName().equals(className)) {
                        try {
                            result.bytes = zipFile.getInputStream(entry).readAllBytes();
                            result.entry = this;
                            result.valid = true;
                        }
                        catch (IOException e) {
                            result.valid = false;
                        }
                        return result;
                    }
                }
                result.valid = false;
                return result;
            }
        } catch (IOException e) {
            ReadClassResult readClassResult = new ReadClassResult();
            readClassResult.valid = false;
            return readClassResult;
        }
    }

    @Override
    public String toString() {
        return absoluteZipPath;
    }
}
