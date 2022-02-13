package com.example.datastructor.Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Heap_Sort {
    public void headAdjust(int[] a, int k, int len) {
        int temp = a[k];
        for (int i = 2 * k + 1; i <= len-1; i = 2 * i + 1) {
            if (i < len - 1 && a[i] < a[i + 1]) {   // i<len-1 是为了防止数组下标越界
                i++;
            }
            if (temp >= a[i]) {
                break;
            } else {
                a[k] = a[i];
                k = i;
            }
        }
        a[k] = temp;
    }

    public void buildMaxHeap(int[] a) {
        for (int i = a.length / 2 -1; i >= 0; i--) {
            headAdjust(a,i,a.length);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int[] heapSort(int[] a) {
        buildMaxHeap(a);
        for (int i = a.length-1; i > 0; i--) {
            swap(a, i, 0);
            headAdjust(a, 0, i);
        }
        return a;
    }

    @Test
    public void test() {
        int[] a = {3, 2, 7, 5, 6, 4, 10, 9, 1, 8};
        System.out.println(Arrays.toString(heapSort(a)));
    }

    @Test
    public void test2() {
        int[] a = new int[100000];
        for (int i = 0; i < 100000; i++) {
            double x = Math.random() * 1000;
            a[i] = (int) x;
        }
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
