package com.csms.leetcode.number.n1100.n1140;
//最长公共子序列
//中等
public class Leetcode1143 {
public int longestCommonSubsequence3rd(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
        int m = text1.length(), n = text2.length();
        int[] dp = new int[n + 1];
        int tmp = 0;
        for (int i = 1; i <= m; i++) {
            int last = 0;
            for (int j = 1; j <= n; j++) {
                tmp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[j] = last + 1;
                else dp[j] = Math.max(tmp, dp[j - 1]);
                last = tmp;
            }
//            System.out.println(JSON.toJSONString(dp));
        }
        return dp[n];
    }

    public static void main(String[] args) {
    }
}