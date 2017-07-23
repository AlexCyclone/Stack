package com.gmail.babanin.aleksey;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BlackList bl = new BlackList();
        bl.addClass(Scanner.class);
        ObjectStack stack = new StackLIFO(12, bl);
        
        pushInteger(stack, 3);
        pushString(stack);
        pushFile(stack);
        pushScanner(stack);
        pushInteger(stack, 6);
        
        System.out.println();

        for (int i = 0; i < 13; i++) {
            System.out.println(stack.pop());
        }
    }

    public static void pushInteger(ObjectStack stack, int size) {
        for (int i = 0; i < size; i++) {
            int result = stack.push((Integer) 15 + i);
            if (result > 0) {
                System.out.println("Object " + stack.peek().getClass() + " pushed");
            } else {
                if (result == -1) {
                    System.out.println("Stack full");
                } else {
                    System.out.println("Object not supported");
                }
            }
        }
    }

    public static void pushString(ObjectStack stack) {
        for (int i = 0; i < 3; i++) {
            int result = stack.push("Hello world");
            if (result > 0) {
                System.out.println("Object " + stack.peek().getClass() + " pushed");
            } else {
                if (result == -1) {
                    System.out.println("Stack full");
                } else {
                    System.out.println("Object not supported");
                }
            }
        }
    }

    public static void pushFile(ObjectStack stack) {
        int result = stack.push(new File("src"));
        if (result > 0) {
            System.out.println("Object " + stack.peek().getClass() + " pushed");
        } else {
            if (result == -1) {
                System.out.println("Stack full");
            } else {
                System.out.println("Object not supported");
            }
        }
    }

    public static void pushScanner(ObjectStack stack) {
        int result = stack.push(new Scanner(System.in));
        if (result > 0) {
            System.out.println("Object " + stack.peek().getClass() + " pushed");
        } else {
            if (result == -1) {
                System.out.println("Stack full");
            } else {
                System.out.println("Object not supported");
            }
        }
    }
}
