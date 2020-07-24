package com.csms.leetcode.number.other.other;
//递归乘法
//中等
public class LeetcodeMST_08_05 {
public int multiply(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        int ans = 0;

        for (int i = 0; min != 0; i++) {
            if ((min & 1) == 1) {
                ans += max << i;
            }
            min >>= 1;
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}