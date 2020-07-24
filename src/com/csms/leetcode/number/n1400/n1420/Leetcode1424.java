package com.csms.leetcode.number.n1400.n1420;

import java.util.ArrayList;
import java.util.List;

//对角线遍历II
//中等
public class Leetcode1424 {
public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int m = nums.size();
        int n = 0;
        for (List<Integer> num : nums) {
            n = Math.max(num.size(), n);
        }
        List<Integer>[] map = new List[n + m];
        int count = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            List<Integer> st = nums.get(i);
            for (int j = 0; j < st.size(); j++) {
                int sum = i + j;
                if (map[sum] == null) {
                    map[sum] = new ArrayList<>();
                }
                map[sum].add(st.get(j));
                count++;
            }
        }
        int[] result = new int[count];
        int t = 0;
        for (int i = 0; i < map.length; i++) {
            List<Integer> integers = map[i];
            if (integers == null) {
                break;
            }
            for (Integer integer : integers) {
                result[t++] = integer;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}