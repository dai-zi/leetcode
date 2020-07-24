package com.csms.leetcode.number.other.other;

import java.util.HashSet;
import java.util.Set;

//交换和
//中等
public class LeetcodeMST_16_21 {
public int[] findSwapValues(int[] array1, int[] array2) {
		int sum1 = 0;
		int sum2 = 0;
		for (int num: array1) {
			sum1 += num;
		}
		for (int num: array2) {
			sum2 += num;
		}
		int diff = (sum1 - sum2);
	
		if (diff % 2 != 0) return new int[0];
        diff = diff/2; 
        int[] res = new int[2];
		Set<Integer> a2 = new HashSet<Integer>();
		for (int num: array2) {
			a2.add(num);
		}
		for (int n: array1) {
			if (a2.contains(n - diff)){
				res[0] = n;
				res[1] = n - diff;
				break;
			}
		}
		return res[0] == 0? new int[0]: res;
	}

    public static void main(String[] args) {
    }
}