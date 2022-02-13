package com.example.datastructor.PolandCalculator;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Pattern;

public class PolandCalculator {
    private static final String SYMBOL = "[+\\-*/()]";
    private static final int LEVEL_01 = 1;
    private static final int LEVEL_02 = 2;
    private static final int LEVEL_HIGH = Integer.MAX_VALUE;
    private static final String LEFT = "(";
    private static final String RIGHT = ")";
    private static final String ADD = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVISION = "/";

    //把中缀表达式字符串转成List
    public List<String> infixExpressionToList(String s) {
        s = replaceAllBank(s);  //对s去空格
        LinkedList<String> ls = new LinkedList<>();
        int i = 0;
        StringBuilder str = new StringBuilder();
        char c;
        do {
            if (((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57) && (c=s.charAt(i)) != '.') {
                ls.add(String.valueOf(c));
                i++;
            } else {
                str = new StringBuilder();
                while (i < s.length() && (((c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) || (c = s.charAt(i)) == '.')) {
                    str.append(c);
                    i++;
                }
                ls.add(str.toString());
            }
        } while (i < s.length());
        return ls;
    }

    //把中缀表达式转成后缀表达式
    public List<String> parseSuffixExpressionList(List<String> ls) {
        Stack<String> stack = new Stack<>();
        List<String> data = Collections.synchronizedList(new ArrayList<>());
        for (String each : ls) {
            if (isOperation(each)) {
                //each的优先级>栈顶
                if (stack.isEmpty() || LEFT.equals(each) || (calcLevel(each) > calcLevel(stack.peek()) && calcLevel(each) < LEVEL_HIGH)) {
                    stack.push(each);
                } else if (!stack.isEmpty() && calcLevel(each) <= calcLevel(stack.peek())) {    //each的优先级<=栈顶
                    while (!stack.isEmpty() && calcLevel(each) <= calcLevel(stack.peek())) {
                        if (calcLevel(stack.peek()) == LEVEL_HIGH) {
                            break;  //一直弹到出现括号为止
                        }
                        data.add(stack.pop());
                    }
                    stack.push(each);
                } else if (RIGHT.equals(each)) {
                    while (!stack.isEmpty()) {
                        if (LEVEL_HIGH == calcLevel(stack.peek())) {
                            stack.pop();
                            break;
                        }
                        data.add(stack.pop());
                    }
                }
            } else if (isNumber(each)) {
                data.add(each);
            }
        }
        while (!stack.isEmpty()) {
            data.add(stack.pop());
        }
        return data;
    }

    public float calculate(String expression) {
        Stack<String> stack = new Stack<>();
        List<String> ls = parseSuffixExpressionList(infixExpressionToList(expression));
        for (String item : ls) {
            if (isNumber(item)) {
                stack.push(item);
            } else if (isOperation(item)) {
                float num2 = Float.parseFloat(stack.pop());
                float num1 = Float.parseFloat(stack.pop());
                float res = 0;
                switch (item) {
                    case "+":
                        res = num1 + num2;  break;
                    case "-":
                        res = num1 - num2;  break;
                    case "*":
                        res = num1 * num2;  break;
                    case "/":
                        res = num1 / num2;  break;
                    default:
                        throw new RuntimeException("运算符有误");
                }
                stack.push(res + "");
            }
        }
        return Float.parseFloat(stack.pop());
    }

    public static String replaceAllBank(String s) {
        return s.replaceAll("\\s+", "");
    }

    //判断str是否是运算符
    public boolean isOperation(String str) {
        return str.matches(SYMBOL);
    }

    //判断是否是操作数
    public boolean isNumber(String str) {
        return Pattern.compile("^?[.\\d]*$").matcher(str).matches();
    }

    public int calcLevel(String s) {
        if (ADD.equals(s) || MINUS.equals(s)) {
            return LEVEL_01;
        } else if (MULTIPLY.equals(s) || DIVISION.equals(s)) {
            return LEVEL_02;
        } else {
            return LEVEL_HIGH;
        }
    }

    @Test
    public void test() {
        List<String> strings = infixExpressionToList("1.2 + 3 *4-(2-3)/2.01");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void test2() {
        System.out.println(replaceAllBank("1.2 + 3 *4-(2-3)/2.01"));
    }

    @Test
    public void test3() {
        System.out.println(parseSuffixExpressionList(infixExpressionToList("1.1 +   (2.2-3)*4.0")));
    }

    @Test
    public void test4() {
        System.out.println(calculate("1.1 +   (2.2-3)*4.0"));
    }
}
