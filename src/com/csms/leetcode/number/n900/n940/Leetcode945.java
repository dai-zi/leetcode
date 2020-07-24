package com.csms.leetcode.number.n900.n940;
//使数组唯一的最小增量
//中等
public class Leetcode945 {
public int minIncrementForUnique(int[] A) {
        int[] count = new int[80000];
        for (int x: A) count[x]++;

        int ans = 0, taken = 0;

        for (int x = 0; x < 80000; ++x) {
            if (count[x] >= 2) {
                taken += count[x] - 1;
                ans -= x * (count[x] - 1);
            }
            else if (taken > 0 && count[x] == 0) {
                taken--;
                ans += x;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}