package com.csms.leetcode.number.n1000.n1080;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//受标签影响的最大值
//中等
public class Leetcode1090 {
public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int len = values.length;
        int[][] items = new int[len][2];
        for (int i = 0; i < len; ++i) {
            items[i][0] = values[i];
            items[i][1] = labels[i];
        }
        Arrays.sort(items, Comparator.comparingInt(i -> -i[0]));
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] item : items) {
            int label_count = map.getOrDefault(item[1], 0);
            if (label_count < use_limit) {
                res += item[0];
                if (--num_wanted == 0)
                    break;
                map.put(item[1], label_count + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}