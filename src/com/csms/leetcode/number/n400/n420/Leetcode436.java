package com.csms.leetcode.number.n400.n420;

import java.util.TreeMap;

//寻找右区间
//中等
public class Leetcode436 {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        TreeMap<Integer, Integer> tree = new TreeMap<>();

        for (int i = 0; i < n; i++)
            tree.put(intervals[i][0], i);

        int[] ans = new int[n];

        for (int i = 0; i < n; i++)
            ans[i] = tree.ceilingKey(intervals[i][1]) == null ? -1 : tree.get(tree.ceilingKey(intervals[i][1]));

        return ans;
    }
    public static void main(String[] args) {
    }
}