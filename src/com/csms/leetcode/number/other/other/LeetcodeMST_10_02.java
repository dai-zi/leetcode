package com.csms.leetcode.number.other.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//变位词组
//中等
public class LeetcodeMST_10_02 {
public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        HashMap<String, List<String>> map = new HashMap<>(len);
        for (String str : strs) {
            int[] count = new int[26];
            int str_len = str.length();
            for (int i = 0; i < str_len; ++i)
                ++count[str.charAt(i) - 'a'];
            StringBuilder sb = new StringBuilder(100);
            for (int num : count)
                sb.append(num + '.');
            map.computeIfAbsent(sb.toString(), unused -> new LinkedList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
    }
}