package com.example.datastructor.Search;

import com.example.datastructor.Sort.Insert_Sort;
import org.junit.jupiter.api.Test;

//折半查找 非递归实现
public class Binary_Search {
    public static int binarySearch(int[] a, int key) {
        int low = 0, mid, high = a.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else if (key < a[mid]) {
                high = mid - 1;
            }
        }
        return -1;
    }


    @Test
    public void test() {
        int[] a = {0, -5, 3, 2, 7, 5, 6, 4, 10, 9, 1, 8, -1, -3, 0};
        //折半查找，在查找之前需要对待查找表进行排序
        System.out.println(binarySearch(Insert_Sort.insertSort2(a), 0));
    }

}
