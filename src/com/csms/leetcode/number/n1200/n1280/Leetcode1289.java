package com.csms.leetcode.number.n1200.n1280;
//下降路径最小和II
//困难
public class Leetcode1289 {
    public int minFallingPathSum(int[][] arr) {
        int row = arr.length, column = arr[0].length;
        int[][] dp = new int[2][column];
        int cur = 1, pre = 0;   //cur和pre控制两行轮流充当第i行和第i-1行
        int minIndex = 0, secondIndex = 0;
        for (int i = 0; i < row; i++) {
            int nextMinIndex = 0;
            for (int j = 0; j < column; j++) {
                if(j != minIndex)
                    dp[cur][j] = dp[pre][minIndex] + arr[i][j];
                else dp[cur][j] = dp[pre][secondIndex] + arr[i][j];
                nextMinIndex = dp[cur][nextMinIndex] > dp[cur][j] ? j: nextMinIndex;
            }
            minIndex = nextMinIndex;
            secondIndex = findSecondIndex(dp, cur, minIndex);
            int temp = cur;
            cur = pre;
            pre = temp;
        }
        return dp[pre][minIndex];
    }
    private int findSecondIndex(int[][] dp, int cur, int minIndex){ //找第二小的元素的下标
        int secondIndex = -1;
        for (int j = 0; j < dp[0].length; j++) {
            if(j == minIndex)
                continue;
            if(secondIndex == -1)
                secondIndex = j;
            else secondIndex = dp[cur][secondIndex] > dp[cur][j] ? j: secondIndex;
        }
        return secondIndex;
    }
    public static void main(String[] args) {
    }
}