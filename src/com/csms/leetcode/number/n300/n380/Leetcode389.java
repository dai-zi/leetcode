package com.csms.leetcode.number.n300.n380;
//找不同
//简单
public class Leetcode389 {
    public char findTheDifference(String s, String t) {
        char res = 0;
        int lens = s.length();
        for (int i = 0; i < lens; i ++) {
            res ^= s.charAt(i)^ t.charAt(i);
        }
        res ^= t.charAt(lens);
        return res;
    }
    public static void main(String[] args) {
    }
}