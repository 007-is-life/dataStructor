package com.example.datastructor.MiGong;

public class MiGong {
    public static void main(String[] args) {
        //构造地图 1是墙，2是走过可通，3是走过不通(走过然后被回溯了)，0是未走过
        int[][] map = new int[8][7];
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        map[4][2] = 1;
        map[4][3] = 1;
        map[5][3] = 1;
        map[6][3] = 1;
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        //开始走迷宫
        boolean result = setWay(map, 5, 1);
        System.out.println(result);
        //输出新地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    //出生点设置在map[5][1],按照下右上左的顺序遍历迷宫
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
//感悟，递归分为地推和回溯，回溯的时候会将走过的2变成3.