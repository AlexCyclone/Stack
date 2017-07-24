package com.gmail.babanin.aleksey;

import java.util.Arrays;

public class StackLIFO implements ObjectStack {
    private Object[] stack = new Object[8];
    private int length = 0;
    private int size = Integer.MAX_VALUE;
    private int increment = 8;
    private BlackList bl = new BlackList();
    
    public StackLIFO() {
        super();
    }
    
    public StackLIFO(int size) {
        super();
        this.size = validateSize(size);
    }
    
    public StackLIFO(int size, BlackList bl) {
        super();
        this.size = size;
        this.bl = bl;
    }

    public StackLIFO(BlackList bl) {
        super();
        this.bl = bl;
    }

    private final int validateSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        return size;
    }

    @Override
    public Object pop() {
        if (length == 0) {
            return null;
        }
        Object object = stack[length - 1];
        stack[length - 1] = null;
        length -= 1;
        return object;
    }

    @Override
    public int push(Object object) {
        if (length == size) {
            return -1;
        }
        if (object == null) {
            return -2;
        }
        if (bl.inList(object.getClass())) {
            return -2;
        }
        
        if (length == stack.length) {
            resize();
        }
        stack[length] = object;
        length += 1;
        return length;
    }

    @Override
    public Object peek() {
        if (length == 0) {
            return null;
        }
        return stack[length - 1];
    }

    private void resize() {
        if (size - stack.length < increment) {
            increment = size - stack.length;
        }
        stack = Arrays.copyOf(stack, stack.length + increment);
    }

}
