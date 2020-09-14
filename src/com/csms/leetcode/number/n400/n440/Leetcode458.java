package com.csms.leetcode.number.n400.n440;
//可怜的小猪
//困难
public class Leetcode458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(states));
    }

    public static void main(String[] args) {
    }
}