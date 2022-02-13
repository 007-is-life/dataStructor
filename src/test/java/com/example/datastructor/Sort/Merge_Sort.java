package com.example.datastructor.Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//归并排序
public class Merge_Sort {
    public void merge(int[] a, int low, int mid, int high) {
        int[] b = new int[a.length];
        //if (high + 1 - low >= 0) System.arraycopy(a, low, b, low, high + 1 - low);
        for (int k = low; k <= high; k++) {
            b[k] = a[k];
        }
        int i,j,k;
        for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
            if (b[i] < b[j]) {
                a[k] = b[i++];
            } else {
                a[k] = b[j++];
            }
        }
        while (i <= mid) {
            a[k++] = b[i++];
        }
        while (j <= high) {
            a[k++] = b[j++];
        }
    }

    public void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }
    //对mergeSort的封装，这样调用归并排序的方式时只需要传递待排序的数组就可以了。
    public int[] mergeSort2(int[] a) {
        mergeSort(a, 0, a.length - 1);
        return a;
    }

    @Test
    public void test() {
        int[] a = {3, 2, 7, 5, 6, 4, 10, 9, 1, 8};
//        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(mergeSort2(a)));
    }

    @Test
    public void test2() {   // 耗时2s744ms
        int[] a = new int[100000];
        for (int i = 0; i < 100000; i++) {
            double x = Math.random() * 1000;
            a[i] = (int) x;
        }
        System.out.println(Arrays.toString(mergeSort2(a)));
    }
}
