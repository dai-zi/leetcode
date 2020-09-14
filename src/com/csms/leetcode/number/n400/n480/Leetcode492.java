package com.csms.leetcode.number.n400.n480;
//构造矩形
//简单
public class Leetcode492 {
    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        if (sqrt * sqrt == area) {
            return new int[]{sqrt, sqrt};
        }
        for (int i = sqrt; i >= 1; i--) {
            if (area % i == 0) {
                return new int[]{area / i, i};
            }
        }
        return null;
    }
    public static void main(String[] args) {
    }
}