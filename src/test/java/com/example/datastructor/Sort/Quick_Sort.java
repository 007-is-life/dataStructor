package com.example.datastructor.Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//快速排序
public class Quick_Sort {
    public int[] quickSort(int[] a, int low, int high) {
        if (low < high) {   //跳出递归的条件
            int pivotPos = partition(a, low, high);
            quickSort(a, low, pivotPos - 1);
            quickSort(a, pivotPos + 1, high);
        }
        return a;
    }

    public int partition(int[] a, int low, int high) {
        int pivot = a[low];
        while (low < high) {
            while (low < high && a[high] >= pivot) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= pivot) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = pivot;
        return low;
    }

    @Test
    public void test() {
        int[] a = {3, 2, 7, 5, 6, 4, 10, 9, 1, 8};
        System.out.println(Arrays.toString(quickSort(a, 0, a.length-1)));
    }

    @Test
    public void test2() {
        int[] a = new int[100000];
        for (int i = 0; i < 100000; i++) {
            double x = Math.random() * 1000;
            a[i] = (int) x;
        }
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
