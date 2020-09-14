package com.csms.leetcode.number.n0.n40;
//跳跃游戏
//中等
public class Leetcode55 {
    //贪心
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
    //
    public static void main(String[] args) {
    }
}