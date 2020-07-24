package com.csms.leetcode.number.other.other;
//回文排列
//简单
public class LeetcodeMST_01_04 {
public boolean canPermutePalindrome(String s) {
        int[] dp = new int[128];
        for (int i = 0; i < s.length(); i++) {
            dp[s.charAt(i)]++;
        }
        boolean flag = s.length() % 2 == 0 ? true : false;
        int odd = 0;
        for (int i = 0; i < 128; i++) {
            if (flag) {
                if (dp[i] % 2 != 0){
                    return false;
                }
            } else { // 如果len是奇数
                // 只允许一个位置的元素是奇数
                if (dp[i] % 2 != 0){
                    odd++;
                    if (odd > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
    }
}