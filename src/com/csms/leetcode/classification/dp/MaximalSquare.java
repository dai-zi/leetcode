package com.csms.leetcode.classification.dp;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int max = 0;

        //java 里数据的两个维度长度不一定相等
        int[][] dp = new int [matrix.length][matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++){
            dp[0][i] = matrix[0][i] - '0';
            if(dp[0][i] > max){
                max = dp[0][i];
            }
        }
        for(int i = 0; i < matrix.length; i++){
            dp[i][0] = matrix[i][0] - '0';
            if(dp[i][0] > max){
                max = dp[i][0];
            }
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                }else{
                    dp[i][j] = 0;
                }
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        return max * max;
    }
}
