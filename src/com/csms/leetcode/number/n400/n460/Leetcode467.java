package com.csms.leetcode.number.n400.n460;
//环绕字符串中唯一的子字符串
//中等
public class Leetcode467 {
    public int findSubstringInWraproundString(String p){
        int[] dp = new int[26];
        int cnt = 1, n = p.length();
        char[] cs = (" " + p).toCharArray();
        for(int i = 1; i <= n; i++){
            int idx = cs[i] - 'a';
            if(check(cs[i - 1], cs[i])) cnt++;
            else cnt = 1;
            dp[idx] = Math.max(dp[idx], cnt);
        }
        int ans = 0;
        for(int i = 0; i < 26; i++) ans += dp[i];
        return ans;
    }

    public boolean check(char a, char b){
        if(a == 'z' && b == 'a') return true;
        return b - a == 1;
    }

    public static void main(String[] args) {
    }
}