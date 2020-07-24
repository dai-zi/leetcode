package com.csms.leetcode.number.n1200.n1200;
//尽可能使字符串相等
//中等
public class Leetcode1208 {
public int equalSubstring(String s, String t, int maxCost) {
        int len = Math.min(s.length(), t.length());
        int ret = 0;
        for (int left = 0, right = 0, sum = 0; right < len; right++) {
            sum += Math.abs(s.charAt(right) - t.charAt(right));
            if (sum <= maxCost) {
                ret = Math.max(ret, right - left + 1);
            } else {
                sum -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
    }
}