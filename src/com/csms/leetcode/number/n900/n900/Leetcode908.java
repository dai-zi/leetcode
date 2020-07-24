package com.csms.leetcode.number.n900.n900;
//最小差值I
//简单
public class Leetcode908 {
public int smallestRangeI(int[] A, int K) {
        int min = A[0], max = A[0];
        for (int x: A) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return Math.max(0, max - min - 2*K);
    }
	
    public static void main(String[] args) {
    }
}