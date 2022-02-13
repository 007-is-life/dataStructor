package com.example.datastructor.test;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char key;
        while (true) {
            System.out.println("请输入操作");
            key = scanner.next().charAt(0);
            if (key == 'a') break;
            if (key == 'b') {
                System.out.println("跳出一次循环");
                continue;
            }
            if (key == 'c') {
                System.out.println("输入了" + key);
            }
        }
    }

    @Test
    public void test(int n) {
        if (n > 2) {
            test(n-1);
        }
        System.out.printf("n=%d\n", n);
        System.out.println("调用了一次");
    }

    @Test
    public void test1() {
        String[] a = {"001","002"};
        System.out.println(a[0]);
    }


}
