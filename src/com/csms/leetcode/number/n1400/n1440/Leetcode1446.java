package com.csms.leetcode.number.n1400.n1440;
//连续字符
//简单
public class Leetcode1446 {
public int maxPower(String s) {
        if (s.length() < 2) return s.length();
        char[] ch_array = s.toCharArray();
        int res = 0, count = 1;
        for (int i = 1; i < ch_array.length; ++i) {
            if (ch_array[i] == ch_array[i - 1])
                ++count;
            else {
                res = Math.max(res, count);
                count = 1;
            }
        }
        return Math.max(res, count);
    }

    public static void main(String[] args) {
    }
}