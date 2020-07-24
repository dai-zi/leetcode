package com.csms.leetcode.number.n800.n860;
//转置矩阵
//简单
public class Leetcode867 {
public int[][] transpose(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                ans[c][r] = A[r][c];
            }
        return ans;
    }
    public static void main(String[] args) {
    }
}