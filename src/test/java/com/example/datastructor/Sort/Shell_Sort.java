package com.example.datastructor.Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//希尔排序
public class Shell_Sort {
    public static int[] shellSort(int[] a) {
        int sentry,i,j;
        for (int dk = (a.length) / 2; dk >= 1; dk /= 2) {
            for (i = dk; i < a.length; i++) {
                if (a[i] < a[i - dk]) {
                    sentry = a[i];
                    for (j = i - dk; j >= 0 && sentry < a[j]; j -= dk) {
                        a[j+dk] = a[j];
                    }
                    a[j+dk] = sentry;
                }
            }
        }
        return a;
    }

    @Test
    public void test() {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        System.out.println(Arrays.toString(shellSort(a)));
    }

    @Test
    public void test2() {
        int[] a = new int[100000];
        for (int i = 0; i < 100000; i++) {
            double x = Math.random() * 1000;
            a[i] = (int) x;
        }
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }
//总结，根据增量dk把父表分成若干子表，然后对子表轮流进行直接插入排序。再减小增量，然后重新分子表，继续这个过程。
}
