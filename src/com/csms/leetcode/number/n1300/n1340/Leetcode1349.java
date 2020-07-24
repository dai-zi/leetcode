package com.csms.leetcode.number.n1300.n1340;
//参加考试的最大学生数
//困难
public class Leetcode1349 {
    private int ok(char[][] grid, int x, int m, int cur) {
        int cnt = 0;//检查合理性 同时进行1的计数
        for (int i = 0; i < m; i++) {
            int a = x & (1 << i);
            if (a != 0) cnt++;
            if (grid[cur][i] == '#' && (a) != 0)//坏的位置不能有人
                return -1;
            if (i > 0) {
                int b = x & (1 << (i - 1));//一行中连续的位置不能同时有人
                if (a != 0 && b != 0) return -1;
            }
        }
        return cnt;
    }
    public int maxStudents(char[][] seats) {
        int n = seats.length;
        if (n == 0) return 0;
        int m = seats[0].length;
        int[][] grid = new int[n][m];
        int total = 1 << m;
        int[][] dp = new int[n + 1][total + 1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < total; j++) {
                int one = ok(seats, j, m, i - 1);
                if (one == -1) continue;
                for (int k = 0; k < total; k++) {
                    //枚举上一个状态，通过左移和右移来判断左前和右前是否冲突
                    if (((j << 1) & k) != 0 || ((j >> 1) & k) != 0) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + one);
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
    }
}