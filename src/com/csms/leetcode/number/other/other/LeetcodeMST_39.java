package com.csms.leetcode.number.other.other;
//数组中出现次数超过一半的数字
//简单
public class LeetcodeMST_39 {
public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    public static void main(String[] args) {
    }
}