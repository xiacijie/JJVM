package org.jjvm.runtime;

public class Thread {
    public int pc;
    public Stack stack;

    public Thread() {
        stack = new Stack(1024);
        pc = 0;
    }

    public void pushFrame(Frame frame) throws Exception {
        stack.push(frame);
    }

    public Frame popFrame() throws Exception {
        return stack.pop();
    }

    public Frame currentFrame() throws Exception {
        return stack.top();
    }
}
