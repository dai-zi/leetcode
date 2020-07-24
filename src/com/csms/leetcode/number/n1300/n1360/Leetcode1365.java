package com.csms.leetcode.number.n1300.n1360;
//有多少小于当前数字的数字
//简单
public class Leetcode1365 {
public int[] smallerNumbersThanCurrent(int[] nums) {
    // 统计出现频率 frequency
    int[] freq = new int[101]; // 索引即数值
    for (int num : nums) freq[num]++;

    // 对频率(而非对原数组nums)从前到后累加
    for (int i = 1; i < freq.length; i++) {
        freq[i] = freq[i] + freq[i - 1];
    }

    // 输出结果
    int[] res = new int[nums.length];
    for (int i = 0; i < res.length; i++) {
        if (nums[i] > 0) res[i] = freq[nums[i] - 1];
    }
    return res;
}
    public static void main(String[] args) {
    }
}