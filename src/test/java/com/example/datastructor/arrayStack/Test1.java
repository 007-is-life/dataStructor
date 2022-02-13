package com.example.datastructor.arrayStack;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

public class Test1 {
    private static final String SYMBOL = "[+\\-*/()]";

    @Test
    public void test1() {
        ArrayStack stack = new ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.push(5);
        stack.traversal();

//        System.out.println(stack.priority('*'));
    }

    @Test
    public void test2() {
        boolean flag = Pattern.compile("^[-+]?[.\\d]*$").matcher("1.a2").matches();
        System.out.println(flag);
        System.out.println("*".matches(SYMBOL));
        float a = Float.parseFloat("1.2") + 2;
        System.out.println(a);
    }
}
