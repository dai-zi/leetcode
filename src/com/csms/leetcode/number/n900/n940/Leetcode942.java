package com.csms.leetcode.number.n900.n940;
//增减字符串匹配
//简单
public class Leetcode942 {
public int[] diStringMatch(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }

        ans[N] = lo;
        return ans;
    }
    public static void main(String[] args) {
    }
}