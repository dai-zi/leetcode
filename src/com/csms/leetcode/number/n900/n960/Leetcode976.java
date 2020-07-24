package com.csms.leetcode.number.n900.n960;

import java.util.Arrays;

//三角形的最大周长
//简单
public class Leetcode976 {
public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i+1] > A[i+2])
                return A[i] + A[i+1] + A[i+2];
        return 0;
    }

    public static void main(String[] args) {
    }
}