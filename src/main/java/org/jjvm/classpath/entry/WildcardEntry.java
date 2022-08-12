package org.jjvm.classpath.entry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.jjvm.exception.JJException;

public class WildcardEntry extends CompositeEntry{

    public WildcardEntry(String pathList)  {
        super(String.join(File.pathSeparator, getPaths(pathList.substring(0, pathList.length() - 1))));
    }

    private static ArrayList<String> getPaths(String baseDirPath)  {
        ArrayList<String> result = new ArrayList<>();

        if (!(new File(baseDirPath)).exists()) {
            JJException.throwException(baseDirPath + " does not exists!");
        }

        File dir = new File(baseDirPath);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
          for (File file : directoryListing) {
                if (file.getName().endsWith(".jar") || file.getName().endsWith(".JAR")) {
                    String path = "";
                    try {
                        path = file.getCanonicalPath();
                    }
                    catch(Exception e) {
                        JJException.throwException(e.getMessage());
                    }
                    
                    result.add(path);
                }
          }
        } else {
            JJException.throwException(baseDirPath + " is not a directory!");
        }
        
        return result;
    }
}
