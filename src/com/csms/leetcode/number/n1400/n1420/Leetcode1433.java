package com.csms.leetcode.number.n1400.n1420;
//检查一个字符串是否可以打破另一个字符串
//中等
public class Leetcode1433 {
public boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < n; i ++) {
            arr1[s1.charAt(i) - 'a'] ++;
            arr2[s2.charAt(i) - 'a'] ++;
        }
        int cnt1 = 0;
        int cnt2 = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < 26; i ++) {
            cnt1 += arr1[i];
            cnt2 += arr2[i];
            if (cnt1 > cnt2) {
                if (flag2) return false;
                flag1 = true;
            } else if (cnt2 > cnt1) {
                if (flag1) return false;
                flag2 = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}