package com.example.datastructor.Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//冒泡排序
public class Bubble_Sort {
    public static int[] bubbleSort(int[] a) {
        boolean flag;
        int i,j,temp;
        for (i = 0; i < a.length - 1; i++) {
            flag = false;
            for (j = a.length - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
//                    swap(a[j - 1], a[j]);
                    swap3(a, j - 1, j);
//                    temp = a[j-1];
//                    a[j-1] = a[j];
//                    a[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {    //说明本趟冒泡排序没有发生元素交换，剩余元素已经有序,无需继续冒泡了。
                return a;
            }
        }
        return a;
    }

    public void swap(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
    }

    public void swap2(int[] a) {
        int temp = a[0];
        a[0] = a[1];
        a[1] = temp;
    }

    public static void swap3(int[] a, int i, int j) {  //实参到形参是值传递的，如果参数是基本数据类型，形参只是实参的副本，形参再怎么改变也不会影响到实参。
        int temp = a[i];                        //所以把参数设为引用类型，就可以通过形参改变实参对象内部的数据了。
        a[i] = a[j];
        a[j] = temp;
    }

    @Test
    public void test() {
        int[] a = {3, 2, 7, 5, 6, 4, 10, 9, 1, 8};
        System.out.println(Arrays.toString(bubbleSort(a)));
    }

    @Test
    public void test2() {
        int[] b = {1,2};
        System.out.println(Arrays.toString(b));
//        swap(b[0],b[1]);
//        swap2(b);
        swap3(b, 0, 1);
        System.out.println(Arrays.toString(b));
    }

    @Test
    public void test3() {
        int[] a = new int[100000];
        for (int i = 0; i < 100000; i++) {
            double x = Math.random() * 1000;
            a[i] = (int) x;
        }
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
