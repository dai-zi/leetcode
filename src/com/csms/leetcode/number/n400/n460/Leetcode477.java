package com.csms.leetcode.number.n400.n460;
//汉明距离总和
//中等
public class Leetcode477 {
    public int totalHammingDistance(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int one = 0;
            for (int j = 0; j < len; j++) {
                one += (nums[j] & 1);
                nums[j] >>= 1;
            }
            ans += one * (len - one);
        }
        return ans;
    }
    public static void main(String[] args) {
    }
}