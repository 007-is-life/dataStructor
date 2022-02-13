package com.example.datastructor.Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Binary_Sort {
    //折半插入排序
    public static int[] binarySort(int[] a) {
        int i,j,low,mid,high,sentry;
        for (i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                sentry = a[i];
                low = 0;
                high = i-1;
                while (low <= high) {
                    mid = (low + high) / 2;
                    if (a[mid] > sentry) {  //折半查找
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                for (j = i - 1; j >= high + 1; j--) {   //high+1就是插入位
                    a[j + 1] = a[j];
                }
                a[high+1] = sentry;
            }
        }
        return a;
    }

    @Test
    public void test() {
        int[] a = {0, -5, 3, 2, 7, 5, 6, 4, 10, 9, 1, 8, -1, -3, 0};
        System.out.println(Arrays.toString(binarySort(a)));
    }
    @Test
    public void test2() {
        int[] a = new int[100000];
        for (int i = 0; i < 100000; i++) {
            double x = Math.random() * 1000;
            a[i] = (int) x;
        }
        binarySort(a);
        System.out.println(Arrays.toString(a));
    }
}
