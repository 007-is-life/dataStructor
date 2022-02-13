package com.example.datastructor.Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Insert_Sort {
    public static int[] insertSort(int[] a) {
        int n = a.length;
        int i,j;
        for (i = 2; i < n; i++) {
            if (a[i] < a[i - 1]) {
                a[0] = a[i];
                for (j = i - 1; a[0] < a[j]; j--) { //哨兵一定得是数组的a[0]担当，不然跳不出for循环
                    a[j + 1] = a[j];
                }
                a[j+1] = a[0];
            }
        }
        return a;
    }
    //暂且有点问题
    public static int[] insertSort2(int[] a) {
        int sentry;
        int n = a.length;
        int i,j;
        for (i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                sentry = a[i];
                for (j = i - 1; sentry < a[j]; j--) {   //待插元素插在第0位之后，条件从sentry<a[j]跳出来
                    a[j + 1] = a[j];
                    if (sentry < a[0]) {    //待插元素查到第0位，条件从这里跳出来
                        break;
                    }
                }
                if (sentry < a[0]) {    ////待插元素查到第0位，条件从这里跳出来,跳入这里
                    a[j] = sentry;
                } else {    //待插元素插在第0位之后，条件从sentry<a[j]跳出来，跳入这里
                    a[j + 1] = sentry;
                }
            }
        }
        return a;
    }

    @Test
    public void test() {
        int[] a = {0, -5, 3, 2, 7, 5, 6, 4, 10, 9, 1, 8, -1, -3, 0,23,45,11,22,45};
        int[] b = {0, -5,-6};
        System.out.println(Arrays.toString(insertSort2(a)));
    }

    @Test
    public void test2() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            double x = Math.random() * 10;
            a[i] = (int) x;
        }
        insertSort2(a);
        System.out.println(Arrays.toString(a));
    }
}
