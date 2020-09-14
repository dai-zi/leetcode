package com.csms.leetcode.number.n400.n400;
//最长回文串
//简单
public class Leetcode409 {
    //贪心
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }
    //
    public static void main(String[] args) {
    }
}