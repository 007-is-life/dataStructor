package com.example.datastructor.Search;

import org.junit.jupiter.api.Test;

//顺序查找
public class Sequential_Search {
    public static int sequentialSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    //顺序查找的改进版本：在a[0]处设置哨兵，可以省去判断游标i是否越界这一步骤
    public static int sequentialSearch2(int[] a, int key) {
        //设置哨兵
        if (a[0] == key) {
            return 0;
        } else {
            a[0] = key;
        }
        //从右向左遍历数组
        int index = a.length - 1;
        while (a[index] != key) {
            index--;
        }
        return index;
    }

    @Test
    public void test() {
        int[] a = {0, -5, 3, 2, 7, 5, 6, 4, 10, 9, 1, 8, -1, -3, 0};
        System.out.println(sequentialSearch2(a, -3));
    }


}
