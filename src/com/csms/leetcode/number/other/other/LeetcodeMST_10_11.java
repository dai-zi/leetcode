package com.csms.leetcode.number.other.other;

import java.util.Arrays;

//峰与谷
//中等
public class LeetcodeMST_10_11 {
public void wiggleSort(int[] nums) {
        int[] result = nums.clone();
        boolean turn = false;
        int startIndex = 0;
        int l = 0;
        int r = nums.length - 1;
        Arrays.sort(result);
        while (l <= r) {
            if (turn) {
                nums[startIndex] = result[l];
                l++;
            } else {
                nums[startIndex] = result[r];
                r--;
            }
            turn = !turn;
            startIndex++;
        }
    }
    public static void main(String[] args) {
    }
}