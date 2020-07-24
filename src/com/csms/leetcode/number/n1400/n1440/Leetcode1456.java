package com.csms.leetcode.number.n1400.n1440;
//定长子串中元音的最大数目
//中等
public class Leetcode1456 {
public int maxVowels(String s, int k) {
    int n = s.length();
    int count = 0, result = 0;
    int i = 0;
        
    for (int j = 0; j < n; j++) {
        if ("aeiou".indexOf(String.valueOf(s.charAt(j))) != -1) count++;
        if (j > k - 1) {
            if ("aeiou".indexOf(String.valueOf(s.charAt(i))) != -1) count--;
            i++;
        }
        result = Math.max(result, count);
    }
        
    return result;
}

    public static void main(String[] args) {
    }
}