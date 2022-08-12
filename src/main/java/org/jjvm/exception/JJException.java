package org.jjvm.exception;

public class JJException {
    static public void throwException(String msg) {
        System.err.println(msg);
        Thread.dumpStack();
        System.exit(1);
    } 
}
