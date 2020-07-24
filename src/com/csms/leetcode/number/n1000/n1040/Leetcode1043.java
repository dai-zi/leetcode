package com.csms.leetcode.number.n1000.n1040;
//分隔数组以得到最大和
//中等
public class Leetcode1043 {
public int maxSumAfterPartitioning(int[] A, int K) {
    if (A == null || A.length == 0) return 0;
    int len = A.length;
    int[] dp = new int[len + 1];
    for (int i = 0; i <= len; i++) {
        int j = i-1;
        int max = dp[i];
        while ((i - j) <= K && j >= 0) {
            max = Math.max(max, A[j]);
            dp[i] = Math.max(dp[i], dp[j] + max * (i - j));
            j--;
        }
    }
    return dp[len];
}

    public int maxSumAfterPartitioning1(int[] A, int K) {
        int len = A.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            /* 分别计算最后一段区间长度 j ∈[1, K]时的解，并更新位置i时的最优解 */
            int domainMax = A[i];
            for (int j = 1; j <= K && i - j + 1 >= 0; j++) {
                domainMax = Math.max(domainMax, A[i-j+1]);
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i-j] + j*domainMax);
                } else {
                    dp[i] = Math.max(dp[i], j*domainMax);
                }
            }
        }
        return dp[len-1];
    }
    public static void main(String[] args) {
    }
}