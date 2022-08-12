package org.jjvm.runtime;

public class Thread {
    public int pc;
    public Stack stack;

    public Thread() {
        stack = new Stack(1024);
        pc = 0;
    }

    public void pushFrame(Frame frame)  {
        stack.push(frame);
    }

    public Frame popFrame()  {
        return stack.pop();
    }

    public Frame currentFrame()  {
        return stack.top();
    }
}
