package com.example.datastructor.EightQueen;

import org.junit.jupiter.api.Test;

import java.util.List;

//八皇后问题
public class EightQueen {
    //皇后数量
    int max = 8;
    //有多少种下法
    static int count = 0;
    //进行了多少次判断
    static int judgeCount = 0;
    //第几个元素代表第几个皇后，列值代表皇后所处的列，每行必定一个皇后
    int[] array = new int[max];

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.check(0);    //静态方法里面不能直接调用非静态方法
        System.out.println("有多少种下法:" + count);
        System.out.println("进行了多少次判断:" + judgeCount);
    }
    //判断第n个皇后是否满足规则
    public boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }
    //下第n个皇后
    public void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;   //第n个皇后摆在第i列
            if (judge(n)) { //判断第n个皇后是否符合规则，若符合，摆下一个皇后
                check(n + 1);
            }
        }
    }
    //打印8个皇后的摆法
    public void print() {
        count++;
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //总结；递推的过程中遇到下一个check()会暂定本check()的执行。一直到栈顶的check()执行完毕弹出栈顶，然后回溯到上一个check()继续递推。

    @Test
    public void test() {
        Solution solution = new Solution();
        List<List<String>> x = solution.solveNQueens(4);
        System.out.println(x);
        //List套一个数组，数组套一个字符串，char[]转成字符串
    }
}