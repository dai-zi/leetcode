package com.csms.leetcode.number.n1300.n1320;
//删除回文子序列
//简单
public class Leetcode1332 {
public int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        boolean isPalindrome = true;
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome ? 1 : 2;
    }

    public static void main(String[] args) {
    }
}