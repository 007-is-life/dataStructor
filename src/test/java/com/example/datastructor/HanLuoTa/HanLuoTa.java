package com.example.datastructor.HanLuoTa;

import org.junit.jupiter.api.Test;

public class HanLuoTa {
    int count = 0;

    public void change(int n, char one, char two, char three) {
        count++;
        if (n == 1) {
            move(one,three);
            return;
        }
        change(n - 1, one, three, two); //将n-1个盘子从one借助three移到two上
        move(one,three);    //将一个盘子从one移动three上
        change(n - 1, two, one, three); //将n-1个盘子从two借助one移到three上
    }

    public void move(char x, char y) {
        System.out.println(x + "->" + y);
    }

    @Test
    public void test() {
        change(3, 'a', 'b', 'c');
        System.out.println(count);
    }
}
