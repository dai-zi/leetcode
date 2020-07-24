package com.csms.leetcode.number.other.other;
//生存人数
//中等
public class LeetcodeMST_16_10 {
public int maxAliveYear(int[] birth, int[] death) {
        int[] changes = new int[102];
        int len = birth.length, res = 1900, max_alive = 0, cur_alive = 0;
        for (int i = 0; i < len; ++i) {
            ++changes[birth[i] - 1900];
            --changes[death[i] - 1899];
        }
        for (int i = 1; i < 101; ++i) {
            cur_alive += changes[i];
            if (cur_alive > max_alive) {
                max_alive = cur_alive;
                res = 1900 + i;
            }
        }
        return res;
    }
    public static void main(String[] args) {
    }
}