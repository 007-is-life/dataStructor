package com.example.datastructor.array;

public class SparseArray {
    public static void main(String[] args) {
        int[][] a = new int[11][11];
        a[1][2] = 2;
        a[4][5] = 1;
        System.out.print("原数组：");
        for (int[] i : a) {
            System.out.println();
            for (int j : i) {
                System.out.printf("%d\t",j);
            }
        }
        //把原数组转换成稀疏数组
        int count = 0;
        for (int[] i : a) {
            for (int j : i) {
                if (j != 0) {
                    count++;
                }
            }
        }
        int[][] sparseArr = new int[count+1][3];
        sparseArr[0][0] = a.length;
        sparseArr[0][1] = a[0].length;
        sparseArr[0][2] = count;

        int num = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != 0) {
                    sparseArr[num][0] = i;
                    sparseArr[num][1] = j;
                    sparseArr[num][2] = a[i][j];
                    num++;
                }
            }
        }
        //输出稀疏数组
        System.out.println();
        System.out.println("稀疏数组:");
        for (int[] ints : sparseArr) {
            System.out.printf("%d\t%d\t%d\n", ints[0], ints[1], ints[2]);
        }
        //把稀疏数组转换为原数组
        int[][] c = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            c[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //输出原二维数组
        System.out.print("原二维数组：");
        for (int[] i : c) {
            System.out.println();
            for (int j : i) {
                System.out.printf("%d\t",j);
            }
        }
    }
}
