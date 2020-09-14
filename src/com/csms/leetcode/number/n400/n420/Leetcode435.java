package com.csms.leetcode.number.n400.n420;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;
import java.util.Comparator;

//无重叠区间
//中等
public class Leetcode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        //记录个数
        int count = 0;
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] < right) {
                i++;
                count++;
                right = Math.min(right, intervals[i][1]);
            }

            i++;
        }
        return count;
    }

    public static void main(String[] args) {
    }
}