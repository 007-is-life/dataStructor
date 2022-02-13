package com.example.datastructor.arrayStack;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String expression = scanner.next();
//            String expression = "7*2*2/3-5+1-5+3-4";
            ArrayStack numStack = new ArrayStack(10);
            ArrayStack operaStack = new ArrayStack(10);
            int index = 0;
            int num1,num2,result;
            int opera;
            char ch;
            String keepNum = "";

            while (true) {
                ch = expression.substring(index, index + 1).charAt(0);
                if (operaStack.isOpera(ch)) {   //是运算符
                    if (!operaStack.isEmpty()) {    //符号栈非空
                        if (operaStack.priority(ch) <= operaStack.priority(operaStack.peak())) {    //待入栈的符号的优先级<=栈顶符号的优先级
                            num2 = numStack.pop();
                            num1 = numStack.pop();
                            opera = operaStack.pop();
                            result = operaStack.calculate(num1, num2, opera);
                            numStack.push(result);
                            operaStack.push(ch);
                        } else {    //待入栈的符号的优先级>栈顶符号的优先级
                            operaStack.push(ch);
                        }
                    } else {    //符号栈为空
                        operaStack.push(ch);
                    }
                } else {    //是数值
                    keepNum += ch;
                    if (index == expression.length() - 1) {
                        numStack.push(Integer.parseInt(keepNum));
                    } else{
                        if (operaStack.isOpera(expression.substring(index + 1, index + 2).charAt(0))) { //如果index的下一位是符号位，keepNum直接入数栈，如果不是，跳出分支继续下次循环
                            numStack.push(Integer.parseInt(keepNum));
                            keepNum = "";
                        }
                    }
                }
                index++;
                if (index > expression.length() - 1) {
                    break;
                }
            }

            while (!operaStack.isEmpty()) {
                num2 = numStack.pop();
                num1 = numStack.pop();
                opera = operaStack.pop();
                result = operaStack.calculate(num1, num2, opera);
                numStack.push(result);
            }

            System.out.printf("表达式计算的结果是%d", numStack.pop());
        }
    }
}
