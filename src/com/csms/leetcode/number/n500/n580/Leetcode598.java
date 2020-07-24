package com.csms.leetcode.number.n500.n580;
//范围求和II
//简单
public class Leetcode598 {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op: ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }

    public static void main(String[] args) {
    }
}