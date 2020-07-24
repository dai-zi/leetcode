package com.csms.leetcode.number.n900.n980;
//按位与为零的三元组
//困难
public class Leetcode982 {
    public int countTriplets(int[] nums) {
        int res = 0;
        int max = 0;

        for (int x : nums) {
            max = Math.max(max, x);
        }


        int max_len = Integer.toBinaryString(max).length();
        int mask = 1;
        for (int i = 0; i < max_len - 1; i++) {
            mask <<= 1;
            mask++;
        }
        int[] map = new int[mask + 1];
        for (int x : nums) {
            for (int y : nums) {

                map[x & y]++;
            }
        }
        for (int x : nums) {
            if (x == 0) {
                res += nums.length * nums.length;
                continue;
            }
            x ^= mask;
            for (int i = x; i > 0; i = (i - 1) & x) {

                res += map[i];

            }
            res += map[0];
        }
        return res;
    }
    public static void main(String[] args) {
    }
}