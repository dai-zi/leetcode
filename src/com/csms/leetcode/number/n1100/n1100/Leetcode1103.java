package com.csms.leetcode.number.n1100.n1100;
//分糖果II
//简单
public class Leetcode1103 {
public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0;
        while (candies != 0) {
            ans[i % num_people] += Math.min(candies, i + 1);
            candies -= Math.min(candies, i + 1);
            i += 1;
        }
        return ans;
    }
    public static void main(String[] args) {
    }
}