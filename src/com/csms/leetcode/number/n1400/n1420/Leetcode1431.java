package com.csms.leetcode.number.n1400.n1420;

import java.util.ArrayList;
import java.util.List;

//拥有最多糖果的孩子
//简单
public class Leetcode1431 {
public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxCandies = 0;
        for (int i = 0; i < n; ++i) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        List<Boolean> ret = new ArrayList<Boolean>();
        for (int i = 0; i < n; ++i) {
            ret.add(candies[i] + extraCandies >= maxCandies);
        }
        return ret;
    }
    public static void main(String[] args) {
    }
}