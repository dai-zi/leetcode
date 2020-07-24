package com.csms.leetcode.number.n1000.n1040;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//距离相等的条形码
//中等
public class Leetcode1054 {
public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int b : barcodes) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int k : map.keySet()) {
            pq.add(new int[]{k, map.get(k)});
        }
        int[] res = new int[barcodes.length];
        int i = 0;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            while (temp[1] -- > 0) {
                res[i] = temp[0];
                i += 2;
                if (i >= barcodes.length) i = 1;
            }
            
        }
        return res;
    }
    public static void main(String[] args) {
    }
}