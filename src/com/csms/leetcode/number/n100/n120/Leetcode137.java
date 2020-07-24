package com.csms.leetcode.number.n100.n120;

import java.util.HashSet;
import java.util.Set;

//只出现一次的数字II
//中等
public class Leetcode137 {
    public int singleNumber(int[] nums) {
        Set<Long> set = new HashSet<>();
        long sumSet = 0, sumArray = 0;
        for(int n : nums) {
            sumArray += n;
            set.add((long)n);
        }
        for(Long s : set) sumSet += s;
        return (int)((3 * sumSet - sumArray) / 2);
    }

    public static void main(String[] args) {
    }
}