package org.jjvm.classpath.entry;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipFile;

public class ZipEntry implements Entry {
    public String absoluteZipPath;

    public ZipEntry(String relativePath) throws IOException {
        File f = new File(relativePath);
        if (! f.exists()) {
            throw new IOException("path: " + relativePath + " does not exist!");
        }
        absoluteZipPath =  f.getCanonicalPath();
    }

    @Override
    public ReadClassResult readClass(String className) throws IOException {
        ZipFile zipFile = new ZipFile(absoluteZipPath);
        Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            java.util.zip.ZipEntry entry = entries.nextElement();
            if (entry.getName().equals(className)) {
                ReadClassResult result = new ReadClassResult();
                result.entry = this;
                result.bytes = zipFile.getInputStream(entry).readAllBytes();
                return result;
            }
        }
        throw new IOException("class name: " + className + " does not exist!");
    }

    @Override
    public String toString() {
        return absoluteZipPath;
    }
}
