package com.csms.leetcode.number.other.other;

import java.util.HashSet;
import java.util.Set;

//数组中重复的数字
//简单
public class LeetcodeMST_03 {
public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
    public static void main(String[] args) {
    }
}