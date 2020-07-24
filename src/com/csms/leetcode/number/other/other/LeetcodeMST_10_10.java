package com.csms.leetcode.number.other.other;

import java.util.ArrayList;
import java.util.Collections;

//数字流的秩
//中等
public class LeetcodeMST_10_10 {
private ArrayList<Integer> list;

    public LeetcodeMST_10_10() {
        list = new ArrayList<>(50000);
    }

    public void track(int x) {
        int idx = Collections.binarySearch(list, x);
        if (idx < 0) idx = -idx - 1;
        list.add(idx, x);
    }

    public int getRankOfNumber(int x) {
        int idx = Collections.binarySearch(list, x);
        if (idx < 0) idx = -idx - 1;
        while (idx < list.size() && list.get(idx) <= x)
            ++idx;
        return idx;
    }

    public static void main(String[] args) {
    }
}