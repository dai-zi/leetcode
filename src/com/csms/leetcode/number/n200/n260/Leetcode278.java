package com.csms.leetcode.number.n200.n260;
//第一个错误的版本
//简单
public class Leetcode278 {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }

    public static void main(String[] args) {
    }
}