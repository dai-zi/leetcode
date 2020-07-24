package com.csms.leetcode.number.n1300.n1300;
//和为零的N个唯一整数
//简单
public class Leetcode1304 {
public int[] sumZero(int n) {
        int[] ans = new int[n];
        int index = 0;
        for (int i = 1; i <= n / 2; i++) {
            ans[index++] = -i;
            ans[index++] = i;
        }
        return ans;
    }
    public static void main(String[] args) {
    }
}