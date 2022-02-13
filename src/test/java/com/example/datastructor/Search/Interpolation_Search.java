package com.example.datastructor.Search;

import com.example.datastructor.Sort.Shell_Sort;
import org.junit.jupiter.api.Test;

//插值查找
public class Interpolation_Search {
    public static int interpolationSearch(int[] a, int key) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + ((key - a[low]) / (a[high] - a[low])) * (high - low);
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    @Test
    public void test() {
        int[] a = {0, -5, 3, 2, 7, 5, 6, 4, 10, 9, 1, 8, -1, -3, 0};
        System.out.println(interpolationSearch(Shell_Sort.shellSort(a), 3));
    }
}
