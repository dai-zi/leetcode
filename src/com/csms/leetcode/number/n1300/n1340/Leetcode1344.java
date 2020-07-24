package com.csms.leetcode.number.n1300.n1340;
//时钟指针的夹角
//中等
public class Leetcode1344 {
public double angleClock(int hour, int minutes) {
    int oneMinAngle = 6;
    int oneHourAngle = 30;

    double minutesAngle = oneMinAngle * minutes;
    double hourAngle = (hour % 12 + minutes / 60.0) * oneHourAngle;

    double diff = Math.abs(hourAngle - minutesAngle);
    return Math.min(diff, 360 - diff);
  }

    public static void main(String[] args) {
    }
}