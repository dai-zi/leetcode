package com.csms.leetcode.number.n0.n20;
//实现strStr()
//简单
public class Leetcode28 {
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}