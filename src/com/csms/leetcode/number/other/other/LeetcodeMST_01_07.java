package com.csms.leetcode.number.other.other;
//旋转矩阵
//中等
public class LeetcodeMST_01_07 {
public void rotate(int[][] grid) {
        // s代表当前圈的行或列的起始索引
        // e代表当前圈的行或列的终止索引
        // 当N为奇数的时候，从外圈往内，最终到达了中心点的时候s=e而跳出循环
        // 当N为偶数的时候，从外圈往内，最终全部都处理完之后s>e而跳出循环
        for (int s = 0, e = grid.length - 1; s < e; s++, e--) {
            for (int j = s; j < e; j++) {
                int tmp = grid[s][j];
                grid[s][j] = grid[e - (j - s)][s];
                grid[e - (j - s)][s] = grid[e][e - (j - s)];
                grid[e][e - (j - s)] = grid[j][e];
                grid[j][e] = tmp;
            }
        }
    }

    public static void main(String[] args) {
    }
}