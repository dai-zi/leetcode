package com.csms.leetcode.number.n1100.n1120;
//最大的以1为边界的正方形
//中等
public class Leetcode1139 {
public int largest1BorderedSquare(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[][][] dp = new int[n+1][m+1][2];

    int res = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (grid[i-1][j-1] == 1) {
          dp[i][j][0] = 1 + dp[i][j-1][0];
          dp[i][j][1] = 1 + dp[i-1][j][1];
          int size = Math.min(dp[i][j][0], dp[i][j][1]);
          while (dp[i][j-size+1][1] < size || dp[i-size+1][j][0] < size) {
            size--;
          }
          res = Math.max(res, size * size);
        }
      }
    }
    return res;
    }

    public static void main(String[] args) {
    }
}