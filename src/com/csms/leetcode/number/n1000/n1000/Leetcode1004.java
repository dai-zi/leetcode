package com.csms.leetcode.number.n1000.n1000;
//最大连续1的个数III
//中等
public class Leetcode1004 {
public int longestOnes(int[] A, int K) {
		int res = 0, i = 0, j = 0;
		for (; i < A.length; i++) {
			if (A[i] == 0) {
				if (K > 0) {
					K--;
				} else {
					res = Math.max(res, i - j);
					while (A[j++] == 1);
				}
			}
		}
		return Math.max(res, i - j);
	}

    public static void main(String[] args) {
    }
}