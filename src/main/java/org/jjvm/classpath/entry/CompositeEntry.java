package org.jjvm.classpath.entry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CompositeEntry implements Entry {
    public ArrayList<Entry> entries = new ArrayList<>();

    public CompositeEntry(String pathList) throws IOException {
        for (String path : pathList.split(File.pathSeparator)) {
            entries.add(EntryFactory.create(path));
        }
    }

    @Override
    public ReadClassResult readClass(String className) {
        for (Entry entry: entries) {
            ReadClassResult result = entry.readClass(className);
            if (result.valid)
                return result;
        }
        ReadClassResult result = new ReadClassResult();
        result.valid = false;
        return result;
    }

    @Override
    public String toString() {
        ArrayList<String> strings = new ArrayList<>();
        for (Entry entry: entries) {
            strings.add(entry.toString());
        }

        return String.join(File.pathSeparator, strings);
    }
}
