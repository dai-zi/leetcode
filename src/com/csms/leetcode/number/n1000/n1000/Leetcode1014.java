package com.csms.leetcode.number.n1000.n1000;
//最佳观光组合
//中等
public class Leetcode1014 {
public int maxScoreSightseeingPair(int[] A) {
    if(A == null || A.length == 0) {
        return 0;
    }

    int max = 0;
    int preMax = A[0] + 0;
    for (int i = 1, length = A.length; i < length; i++) {
        max = Math.max(max, preMax + A[i] - i);
        preMax = Math.max(preMax, A[i] + i);
    }
    return max;
}

    public static void main(String[] args) {
    }
}