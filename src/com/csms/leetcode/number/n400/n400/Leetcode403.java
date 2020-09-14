package com.csms.leetcode.number.n400.n400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//青蛙过河
//困难
public class Leetcode403 {
    //记忆化搜索
    public boolean canCross(int[] stones) {
        int[][] memo = new int[stones.length][stones.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return can_Cross(stones, 0, 0, memo) == 1;
    }
    public int can_Cross(int[] stones, int ind, int jumpsize, int[][] memo) {
        if (memo[ind][jumpsize] >= 0) {
            return memo[ind][jumpsize];
        }
        for (int i = ind + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[ind];
            if (gap >= jumpsize - 1 && gap <= jumpsize + 1) {
                if (can_Cross(stones, i, gap, memo) == 1) {
                    memo[ind][gap] = 1;
                    return 1;
                }
            }
        }
        memo[ind][jumpsize] = (ind == stones.length - 1) ? 1 : 0;
        return memo[ind][jumpsize];
    }

    //记忆化搜索 + 二分搜索
//    public boolean canCross(int[] stones) {
//        int[][] memo = new int[stones.length][stones.length];
//        for (int[] row : memo) {
//            Arrays.fill(row, -1);
//        }
//        return can_Cross(stones, 0, 0, memo) == 1;
//    }
//    public int can_Cross(int[] stones, int ind, int jumpsize, int[][] memo) {
//        if (memo[ind][jumpsize] >= 0) {
//            return memo[ind][jumpsize];
//        }
//        int ind1 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize);
//        if (ind1 >= 0 && can_Cross(stones, ind1, jumpsize, memo) == 1) {
//            memo[ind][jumpsize] = 1;
//            return 1;
//        }
//        int ind2 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize - 1);
//        if (ind2 >= 0 && can_Cross(stones, ind2, jumpsize - 1, memo) == 1) {
//            memo[ind][jumpsize - 1] = 1;
//            return 1;
//        }
//        int ind3 = Arrays.binarySearch(stones, ind + 1, stones.length, stones[ind] + jumpsize + 1);
//        if (ind3 >= 0 && can_Cross(stones, ind3, jumpsize + 1, memo) == 1) {
//            memo[ind][jumpsize + 1] = 1;
//            return 1;
//        }
//        memo[ind][jumpsize] = ((ind == stones.length - 1) ? 1 : 0);
//        return memo[ind][jumpsize];
//    }

    //动态规划
    public boolean canCross2(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }

    //
    public static void main(String[] args) {
    }
}