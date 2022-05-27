package org.jjvm.util;

public class Util {
    static public void abort(String errorMsg) {
        System.out.println(errorMsg);
        System.exit(1);
    }
}
