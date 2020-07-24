package com.csms.leetcode.number.n900.n980;
//坏了的计算器
//中等
public class Leetcode991 {
public int brokenCalc(int X, int Y) {
        int ans = 0;
        while (Y > X) {
            ans++;
            if (Y % 2 == 1)
                Y++;
            else
                Y /= 2;
        }

        return ans + X - Y;
    }

    public static void main(String[] args) {
    }
}