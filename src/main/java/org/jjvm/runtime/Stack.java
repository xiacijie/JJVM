package org.jjvm.runtime;

public class Stack {
    public int maxSize;
    public int size;
    public Frame top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
        top = null;
    }

    public void push(Frame frame) throws Exception{
        if (size > maxSize) {
            throw new Exception("java.lang.StackOverflowError");
        }

        if (top != null) {
            frame.lower = top;
        }

        top = frame;
        size++;
    }

    public Frame pop() throws Exception {
        if (top == null) {
            throw new Exception("JVM stack is empty!");
        }

        Frame currTop = top;
        top = currTop.lower;
        currTop.lower = null;
        size--;
        return currTop;
    }

    public Frame top() throws Exception{
        if (top == null) {
            throw new Exception("JVM Stack is empty!");
        }

        return top;
    }
}
