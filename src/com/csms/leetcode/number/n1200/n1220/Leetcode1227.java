package com.csms.leetcode.number.n1200.n1220;
//飞机座位分配概率
//中等
public class Leetcode1227 {
public double nthPersonGetsNthSeat(int n) {
        if (n == 1) return 1d;
        return 1d / n + (n - 2d) / n * nthPersonGetsNthSeat(n - 1);
    }
	
    public static void main(String[] args) {
    }
}