package org.jjvm.classpath.entry;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipFile;

public class ZipEntry implements Entry {
    public String absoluteZipPath;

    public ZipEntry(String path) throws IOException {
        File f = new File(path);
        if (! f.exists()) {
            throw new IOException("path: " + path + " does not exist!");
        }
        absoluteZipPath =  f.getCanonicalPath();
    }

    @Override
    public ReadClassResult readClass(String className) throws IOException {
        ZipFile zipFile = new ZipFile(absoluteZipPath);
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

    @Override
    public String toString() {
        return absoluteZipPath;
    }
}
