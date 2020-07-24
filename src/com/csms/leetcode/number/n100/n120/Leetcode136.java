package com.csms.leetcode.number.n100.n120;
//只出现一次的数字
//简单
public class Leetcode136 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
    }
}