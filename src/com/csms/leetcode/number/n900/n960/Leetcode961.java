package com.csms.leetcode.number.n900.n960;

import java.util.HashMap;
import java.util.Map;

//重复N次的元素
//简单
public class Leetcode961 {
public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> count = new HashMap();
        for (int x: A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        for (int k: count.keySet())
            if (count.get(k) > 1)
                return k;

        throw null;
    }

    public static void main(String[] args) {
    }
}