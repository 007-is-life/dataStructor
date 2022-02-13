package com.example.datastructor.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//KMP算法 解决字符串匹配问题
public class KMP {
    //暴力匹配算法
    public int violenceMatch(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i -= j-1;   //i,j回溯
                j = 0;
            }
        }
        if (j == s2.length()) {
            return i - j;
        }
        return -1;
    }

    //kmp算法
    public int kmp(String s1, String s2) {
        int[] next = kmpNext(s2);
        for (int i = 0, j = 0; i < s1.length(); i++) {
            while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
                j = next[j-1];
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            if (j == s2.length()) {
                return i-j+1;
            }
        }
        return -1;
    }

    //求子串的部分匹配值
    public int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        //i++：跳入下一个后缀的首字符，相当于在后缀上后移; j++：前缀上的索引j后移一位
        for (int j = 0, i = 1; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(j) != dest.charAt(i)) {
                j = next[j-1];  //j回溯
            }
            if (dest.charAt(j) == dest.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(kmpNext("aaab")));
        System.out.println(kmp("bbc abcdab abcdabcdabde","abcdabd"));
    }


}
