package org.jjvm.runtime;

import org.jjvm.exception.JJException;

public class Stack {
    public int maxSize;
    public int size;
    public Frame top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        top = null;
    }

    public void push(Frame frame) {
        if (size > maxSize) {
            JJException.throwException("java.lang.StackOverflowError");
        }

        if (top != null) {
            frame.lower = top;
        }

        top = frame;
        size++;
    }

    public Frame pop()  {
        if (top == null) {
            JJException.throwException("JVM stack is empty!");
        }

        Frame currTop = top;
        top = currTop.lower;
        currTop.lower = null;
        size--;
        return currTop;
    }

    public Frame top() {
        if (top == null) {
            JJException.throwException("JVM Stack is empty!");
        }

        return top;
    }
}
