package com.csms.leetcode.number.n400.n440;

import java.util.PriorityQueue;

//根据字符出现频率排序
//中等
public class Leetcode451 {
    public String frequencySort(String s) {
        int[] letters = new int[128];
        for (char c : s.toCharArray()) {
            letters[c]++;
        }
        PriorityQueue<Character> heap = new PriorityQueue<>(128, (a, b) -> Integer.compare(letters[b], letters[a]));
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < letters.length; ++i) {
            if (letters[i] != 0) heap.offer((char)i);
        }

        while (!heap.isEmpty()) {
            char c = heap.poll();
            while (letters[c]-- > 0)
                res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
    }
}