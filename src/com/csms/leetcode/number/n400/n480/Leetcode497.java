package com.csms.leetcode.number.n400.n480;

import java.util.HashMap;
import java.util.Random;
import java.util.Stack;
import java.util.TreeMap;

//非重叠矩形中的随机点
//中等
public class Leetcode497 {
    TreeMap<Integer, Integer> map;
    int[][] rects;
    int sum;
    Random r = new Random();
    public Leetcode497(int[][] rects) {
        this.rects = rects;
        map = new TreeMap<>();
        sum = 0;
        for (int i = 0; i < rects.length; i ++) {
            int[] rect = rects[i];
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            map.put(sum, i);
        }
    }

    public int[] pick() {
        int c = map.ceilingKey(r.nextInt(sum) + 1);
        int[] rect = rects[map.get(c)];
        return new int[]{rect[0] + r.nextInt(rect[2] - rect[0] + 1), rect[1] + r.nextInt(rect[3] - rect[1] + 1)};
    }

    public static void main(String[] args) {
    }
}