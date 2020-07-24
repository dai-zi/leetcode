package com.csms.leetcode.number.other.other;

import java.util.Arrays;
import java.util.PriorityQueue;

//最小K个数
//中等
public class LeetcodeMST_17_14 {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);
        Arrays.stream(arr).forEach(num -> heap.offer(num));
        int[] res = new int[k];
        int idx = 0;
        while (idx < k) res[idx++] = heap.poll();
        return res;
    }

    public static void main(String[] args) {
    }
}