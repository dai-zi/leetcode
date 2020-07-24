package com.csms.leetcode.number.n1300.n1320;
//破坏回文串
//中等
public class Leetcode1328 {
public String breakPalindrome(String palindrome) {
        int len = palindrome.length(), half = (len - 2) >> 1;
        if (len < 2) return "";
        char[] ch_arr = palindrome.toCharArray();
        for (int i = 0; i <= half; ++i)
            if (ch_arr[i] > 'a') {
                ch_arr[i] = 'a';
                return String.valueOf(ch_arr);
            }
        ch_arr[len - 1] = 'b';
        return String.valueOf(ch_arr);
    }

    public static void main(String[] args) {
    }
}