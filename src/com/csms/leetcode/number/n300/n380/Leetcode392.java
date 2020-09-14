package com.csms.leetcode.number.n300.n380;
//判断子序列
//简单
public class Leetcode392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int m = s.length() - 1, n = t.length() - 1;
        while (i <= m && j <= n) {
            if (s.charAt(m) == t.charAt(n)) {
                n--;
                m--;
            } else {
                n--;
            }
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == m + 1;
    }
    public boolean isSubsequence1(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
    public static void main(String[] args) {
    }
}