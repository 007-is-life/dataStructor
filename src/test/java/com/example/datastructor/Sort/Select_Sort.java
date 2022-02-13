package com.example.datastructor.Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//简单选择排序
public class Select_Sort {
    public int[] selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    min = j;
                }
            }
            if (i != min) {
                swap(a, i, min);
            }
        }
        return a;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    @Test
    public void test() {
        int[] a = {3, 2, 7, 5, 6, 4, 10, 9, 1, 8};
        System.out.println(Arrays.toString(selectSort(a)));
    }

    @Test
    public void test2() {
        int[] a = new int[100000];
        for (int i = 0; i < 100000; i++) {
            double x = Math.random() * 1000;
            a[i] = (int) x;
        }
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
