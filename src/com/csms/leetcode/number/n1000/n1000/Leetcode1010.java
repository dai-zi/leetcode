package com.csms.leetcode.number.n1000.n1000;
//总持续时间可被60整除的歌曲
//简单
public class Leetcode1010 {
public int numPairsDivisibleBy60(int[] time) {
		int count = 0;
		int[] seconds = new int[60];
		for(int t : time) {
			seconds[t % 60] += 1; 
		}
		count += combination(seconds[30], 2);
		count += combination(seconds[0], 2);
		int i = 1, j = 59;
		while(i < j) {
			count += seconds[i++] * seconds[j--];
		}
		return count;
	}
	
	// 求组合数
	public int combination(int n, int k) {
		long result = 1;
		for(int i = 1; i <= k; i++) {
			result = result * (n - i + 1) / i;
		}
		return (int)result;
	}
    public static void main(String[] args) {
    }
}