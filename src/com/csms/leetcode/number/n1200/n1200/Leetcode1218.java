package com.csms.leetcode.number.n1200.n1200;

import java.util.HashMap;
import java.util.Map;

//最长定差子序列
//中等
public class Leetcode1218 {
public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: arr) {
            int temp = map.getOrDefault(i - difference, 0) + 1;
            map.put(i, temp);
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}