package com.csms.leetcode.number.other.other;
//分式化简
//简单
public class LeetcodeLCP02 {
private int[] recursive(int[] count, int index) {
        if (index == count.length - 1) {
            return new int[]{count[index], 1};
        }

        int[] nextRes = recursive(count, index+1);
        return new int[]{count[index] * nextRes[0] + nextRes[1], nextRes[0]};
    }

    public int[] fraction(int[] cont) {
        return recursive(cont, 0);
    }
    public static void main(String[] args) {
    }
}