package com.csms.leetcode.number.n1200.n1280;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//子串的最大出现次数
//中等
public class Leetcode1297 {
private boolean isMatch(String str, int maxLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
            if (set.size() > maxLetters) {
                return false;
            }
        }

        return set.size() <= maxLetters;
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int len = s.length();
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (i + minSize > len) {
                break;
            }

            String sub = s.substring(i, i + minSize);
            if (isMatch(sub, maxLetters)) {
                countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
            }
        }

        int ansMax = 0;
        for (String str: countMap.keySet()) {
            int count = countMap.get(str);
            if (count > ansMax) {
                ansMax = count;
            }
        }

        return ansMax;
    }
    public static void main(String[] args) {
    }
}