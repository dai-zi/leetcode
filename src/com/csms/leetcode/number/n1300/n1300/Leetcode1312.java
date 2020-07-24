package com.csms.leetcode.number.n1300.n1300;
//让字符串成为回文串的最少插入次数
//困难
public class Leetcode1312 {
    int minInsertions(String s) {
        int n=s.length();
        int[][] dp=new int[n+1][n+1];
        StringBuilder str=new StringBuilder();
        for(int i=n-1;i>=0;i--) str.append(s.charAt(i));
        String s1=str.toString();

        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++) {
                if(s.charAt(i-1)==s1.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
            }

        return n-dp[n][n];
    }
    public static void main(String[] args) {
    }
}