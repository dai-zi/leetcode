package com.csms.leetcode.number.n400.n440;

import java.util.ArrayList;
import java.util.List;

//数组中重复的数据
//中等
public class Leetcode442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
    }
}