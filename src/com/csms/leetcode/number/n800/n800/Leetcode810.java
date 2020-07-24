package com.csms.leetcode.number.n800.n800;
//黑板异或游戏
//困难
public class Leetcode810 {
    public boolean xorGame(int[] nums) {
        int x = 0;
        for (int v : nums) x ^= v;
        return x == 0 || nums.length % 2 == 0;
    }

    public static void main(String[] args) {
    }
}