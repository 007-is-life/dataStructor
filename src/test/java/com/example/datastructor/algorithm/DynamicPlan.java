package com.example.datastructor.algorithm;


//动态规划算法 背包问题
public class DynamicPlan {

    public static void main(String[] args) {
        int[] w = {1, 4, 3};    //物品重量
        int[] val = {1500, 3000, 2000}; //物品价值
        int m = 4;  //背包容量
        int n = val.length; //物品的个数

        int[][] v = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }
        //遍历v数组
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }
        //输出背包中放入了哪些物品
        int i = path.length-1;
        int j = path[0].length-1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个物品放入了背包\n", i);
                j -= w[i - 1];
            }
            i--;
        }
        //遍历path数组
        for (int k = 0; k < path.length; k++) {
            for (int l = 0; l < path[0].length; l++) {
                System.out.print(path[k][l]+" ");
            }
            System.out.println();
        }

    }



}
