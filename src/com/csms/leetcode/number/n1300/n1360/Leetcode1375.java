package com.csms.leetcode.number.n1300.n1360;
//灯泡开关III
//中等
public class Leetcode1375 {
public int numTimesAllBlue(int[] light) {
        int ans = 0;
        int curMax = 0;
        for (int i = 0; i < light.length; i++) {
            curMax = Math.max(curMax, light[i]);
            if (curMax == i + 1) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}