package com.csms.leetcode.number.n300.n320;
//按要求补齐数组
//困难
public class Leetcode330 {
    public int minPatches(int[] nums, int n) {
        int patches = 0, i = 0;
        long miss = 1; // use long to avoid integer overflow error
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) // miss is covered
                miss += nums[i++];
            else { // patch miss to the array
                miss += miss;
                patches++; // increase the answer
            }
        }
        return patches;
    }
    public static void main(String[] args) {
    }
}