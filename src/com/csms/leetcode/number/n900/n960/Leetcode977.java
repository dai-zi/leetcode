package com.csms.leetcode.number.n900.n960;

import java.util.Arrays;

//有序数组的平方
//简单
public class Leetcode977 {
public int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i)
            ans[i] = A[i] * A[i];

        Arrays.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
    }
}