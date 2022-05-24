package org.jjvm.classpath.entry;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class WildcardEntry extends CompositeEntry{

    public WildcardEntry(String pathList) throws IOException {
        super(String.join(File.pathSeparator, getPaths(pathList.substring(0, pathList.length() - 1))));
    }

    private static ArrayList<String> getPaths(String baseDirPath) throws IOException {
        ArrayList<String> result = new ArrayList<>();
        Stream<Path> paths = Files.walk(Paths.get(baseDirPath));
        paths.filter(path -> path.endsWith(".jar") || path.endsWith(".JAR"))
                .forEach(path -> result.add(path.toString()));
        return result;
    }
}
