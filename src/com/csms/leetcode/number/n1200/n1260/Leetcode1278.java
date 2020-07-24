package com.csms.leetcode.number.n1200.n1260;
//分割回文串III
//困难
public class Leetcode1278 {
    public int palindromePartition(String s, int k) {
        int[][] pali= new int[s.length() + 1][s.length() + 1];
        for(int i = s.length(); i >= 1; i--)
        {
            for(int j = i; j <= s.length(); j++)
            {
                if(j - i >= 2)
                    pali[i][j] = pali[i + 1][j - 1];
                if(s.charAt(i - 1) != s.charAt(j - 1))
                    pali[i][j]++;
            }
        }

        int[][] dp = new int[k + 1][s.length() + 1];
        for(int i = 1; i <= k; i++)
        {
            for(int j = i; j <= s.length(); j++)
            {
                if(i == 1)
                    dp[i][j] = pali[i][j];
                else
                {
                    dp[i][j] = dp[i - 1][i - 1] + pali[i][j];
                    for(int x = i; x < j; x++)
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][x] + pali[x + 1][j]);
                }
            }
        }
        return dp[k][s.length()];
    }
    public static void main(String[] args) {
    }
}