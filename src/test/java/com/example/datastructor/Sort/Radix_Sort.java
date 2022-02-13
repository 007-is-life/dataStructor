package com.example.datastructor.Sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

//基数排序
public class Radix_Sort {
    //目前这个基数排序算法不能接受负值
    public static int[] radixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;  //一个多位数余10,100,1000后分别留下1位，2位，3位; 除以1,10,100后分别留下个位，十位，百位。
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for(int i = 0; i < 10;i++){
            bucketList.add(new ArrayList<>());
        }
        for(int i = 0;i < maxDigit;i++,mod *= 10 ,div *= 10){
            for(int j = 0;j < array.length;j++){
                int num = (array[j] % mod) / div;
                bucketList.get(num).add(array[j]);
            }
            int index = 0;
            for(int j = 0;j < bucketList.size();j++){
                for(int k = 0;k < bucketList.get(j).size();k++){
                    array[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }
        return array;
    }
    //这个方法只是重写一遍
    public static int[] radixSort2(int[] a) {
        int max = a[0];
        for (int i : a) {
            max = Math.max(max, i);
        }
        //求最大值的位数
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i : a) {
            bucketList.add(new ArrayList<>());
        }
        int mod = 10, div = 1;
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j : a) {
                int num = (j % mod) / div;
                bucketList.get(num).add(j);
            }
            int index = 0;
            for (ArrayList<Integer> j : bucketList) {
                for (int k : j) {
                    a[index++] = k;
                }
                j.clear();
            }
        }
        return a;
    }

    @Test
    public void test() {
        int[] a = {3, 2, 7, 5, 6, 4, 10, 9, 1, 8};
        System.out.println(Arrays.toString(radixSort2(a)));
    }

}
