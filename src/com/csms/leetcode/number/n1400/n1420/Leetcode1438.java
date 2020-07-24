package com.csms.leetcode.number.n1400.n1420;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//绝对差不超过限制的最长连续子数组
//中等
public class Leetcode1438 {
public int longestSubarray(int[] nums, int limit) {
        if (nums ==null || nums.length==0)
            return 0;
        int curr_max = nums[0]; // 当子数组下最大值 这里初始化为第一个数
        int curr_min = nums[0]; // 当子数组下最大值 这里初始化为第一个数
        Queue<Integer> sub_nums = new LinkedList<>();
        for(int num:nums){
            if (Math.abs(num - curr_max) <=  limit && Math.abs(num - curr_min) <=  limit && Math.abs(curr_max - curr_min) <= limit) {
                curr_max = Math.max(num,curr_max);
                curr_min = Math.min(num,curr_min);
                sub_nums.offer(num);
            }else{
                sub_nums.offer(num);
                sub_nums.poll();
                curr_max = Collections.max(sub_nums); // 当子数组最大值
                curr_min = Collections.min(sub_nums); // 当前子数组最小值
            }
        }

        return sub_nums.size();
    }

    public static void main(String[] args) {
    }
}