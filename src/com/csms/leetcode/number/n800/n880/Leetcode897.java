package com.csms.leetcode.number.n800.n880;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//递增顺序查找树
//简单
public class Leetcode897 {
public int numSpecialEquivGroups(String[] A) {
        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }
    public static void main(String[] args) {
    }
}