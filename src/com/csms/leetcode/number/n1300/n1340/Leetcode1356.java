package com.csms.leetcode.number.n1300.n1340;

import java.util.Arrays;

//根据数字二进制下1的数目排序
//简单
public class Leetcode1356 {
public int[] sortByBits(int[] arr) {
        int[] map = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(map);
        for (int i = 0; i < map.length; i++) {
            map[i] = map[i] % 10000000;
        }
        return map;
    }

    public static void main(String[] args) {
    }
}