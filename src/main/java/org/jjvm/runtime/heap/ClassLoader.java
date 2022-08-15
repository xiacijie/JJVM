package org.jjvm.runtime.heap;

import java.util.HashMap;

import org.jjvm.classfile.ClassFile;
import org.jjvm.classpath.ClassPath;
import org.jjvm.classpath.entry.ReadClassResult;
import org.jjvm.exception.JJException;

public class ClassLoader {
    private ClassPath classPath;
    private HashMap<String, JJClass> classMap;

    public ClassLoader(ClassPath classPath) {
        this.classPath = classPath;
        classMap = new HashMap<>();
    }

    public JJClass loadClass(String name) {
        if (classMap.containsKey(name)) {
            return classMap.get(name);
        }

        return loadNonArrayClass(name);
    }

    private JJClass loadNonArrayClass(String name) {
        ReadClassResult validResult = readClass(name);
        JJClass klass = defineClass(validResult.bytes);
        link(klass);
        System.out.println("[Loaded " + name + " from " + validResult.entry.toString() +"]");
        return klass;
    }

    private ReadClassResult readClass(String name) {
        ReadClassResult result = classPath.readClass(name);
        if (!result.valid) {
            JJException.throwException("java.lang.ClassNotFoundException: " + name);
            return null;
        }

        return result;
    }

    private JJClass defineClass(byte[] data) {
        JJClass klass = parseClass(data);
        klass.classLoader = this;
        resolveSuperClass(klass);
        resolveInterfaces(klass);
        classMap.put(klass.name, klass);
        return klass;
    }

    private JJClass parseClass(byte[] data) {
        ClassFile classFile = ClassFile.parse(data);
        return new JJClass(classFile);
    }

    private void resolveSuperClass(JJClass klass) {
        if (klass.name != "java/lang/Object") {
            klass.superClass = klass.classLoader.loadClass(klass.superClassName);
        }
    }

    private void resolveInterfaces(JJClass klass) {
        int interfaceCount = klass.interfaceNames.length;
        if (interfaceCount > 0) {
            klass.interfaces = new JJClass[interfaceCount];
            for (int i = 0; i < interfaceCount; i ++) {
                klass.interfaces[i] = klass.classLoader.loadClass(klass.interfaceNames[i]);
            }
        }
    }

    private void link(JJClass klass) {
        verify(klass);
        prepare(klass);
    }

    private void verify(JJClass klass) {
        // TODO
    }

    private void prepare(JJClass klass) {
        // TODO
    }
}
