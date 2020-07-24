package com.csms.leetcode.number.n1400.n1400;
//恢复数组
//困难
public class Leetcode1416 {
    public static int numberOfArrays(String s, int k) {
        int n = s.length();
        int[] dp = new int[n+1];
        for (int i = 0; i<n; i++) dp[i] = 0;
        dp[0] = 1;
        int m = 1000000007;
        for (int i = 1; i<=n; i++){
            for (int j = i-1; j>=0; j--){
                if (s.charAt(j) == '0') continue;
                //i比对应的元素下标要大1，即i=1时对应s[0]
                if (Long.valueOf(s.substring(j,i)) <=k){
                    dp[i] = (dp[i]+ dp[j]) % m;
                } else {
                    if (s.charAt(i-1) == '0' && dp[i] == 0)return 0;
                    break;
                }
            }
            dp[i] %= m;
        }
        return dp[n]%m;
    }
    public static void main(String[] args) {
    }
}