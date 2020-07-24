package com.csms.leetcode.number.n400.n440;

import java.util.Arrays;

//分发饼干
//简单
public class Leetcode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int i : s) {
            if (i >= g[j]){
                j++;
                if (j >= g.length){
                    return j;
                }
            }
        }
        return j;
    }
    public static void main(String[] args) {
    }
}