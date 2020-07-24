package com.csms.leetcode.number.n500.n560;

import java.util.Arrays;
import java.util.HashSet;

//分糖果
//简单
public class Leetcode575 {
    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int count = 1;
        for (int i = 1; i < candies.length && count < candies.length / 2; i++)
            if (candies[i] > candies[i - 1])
                count++;
        return count;
    }
    public int distributeCandies1(int[] candies) {
        HashSet < Integer > set = new HashSet< >();
        for (int candy: candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }

    public static void main(String[] args) {
    }
}