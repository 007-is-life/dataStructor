package com.example.datastructor.arrayStack;

public class ArrayStack {
    int top = -1;
    int[] stack;
    int size;

    public ArrayStack(int size) {
        this.stack = new int[size];
        this.size = size;
    }

    public boolean isFull() {
        return this.top == this.size - 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("栈满");
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    public int peak() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top];
    }

    public void traversal() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        for (int i = top; i > -1; i--) {
            System.out.printf("stack[%d]=%d\t", i, stack[i]);
        }
    }

    //判断运算符的优先级
    public int priority(int val) {
        if (val == '+' || val == '-') {
            return 0;
        } else if (val == '*' || val == '/') {
            return 1;
        } else {
            return -1;
        }
    }

    //判断一个字符是否是运算符
    public boolean isOpera(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //定义四则运算法则
    public int calculate(int num1, int num2, int opera) {
        int result = 0;
        switch (opera) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                break;
        }
        return result;
    }
}
