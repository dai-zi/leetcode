package com.csms.leetcode.number.other.other;
//魔术索引
//简单
public class LeetcodeMST_08_03 {
int res = -1;
    public int findMagicIndex(int[] nums) {
        search(nums, 0, nums.length - 1);
        return res;
    }

    private void search(int[] nums, int low, int high) {
        if(low > high) return;
        int mid = low + (high - low) / 2;
        //如果找到，则从左半边继续查找更小的解
        if(nums[mid] == mid) {
            res = mid;
            search(nums, low, mid - 1);
        }
        //如果未找到，则先搜索左半边，左半边无解的情况下再搜索右半边
        else {
            search(nums, low, mid - 1);
            //这边要注意res在之前的查找中可能已经有值
            if(-1 == res || res > high) search(nums, mid + 1, high);
        }
    }

    public static void main(String[] args) {
    }
}