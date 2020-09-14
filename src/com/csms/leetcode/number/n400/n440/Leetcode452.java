package com.csms.leetcode.number.n400.n440;

import java.util.Arrays;
import java.util.Comparator;

//用最少数量的箭引爆气球
//中等
public class Leetcode452 {
    //tan xin
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // sort by x_end
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1];
        for (int[] p : points) {
            xStart = p[0];
            xEnd = p[1];
            // if the current balloon starts after the end of another one,
            // one needs one more arrow
            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
    }
}