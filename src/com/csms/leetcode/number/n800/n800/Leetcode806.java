package com.csms.leetcode.number.n800.n800;
//写字符串需要的行数
//简单
public class Leetcode806 {
public int[] numberOfLines(int[] widths, String S) {
        int lines = 1, width = 0;
        for (char c: S.toCharArray()) {
            int w = widths[c - 'a'];
            width += w;
            if (width > 100) {
                lines++;
                width = w;
            }
        }

        return new int[]{lines, width};
    }

    public static void main(String[] args) {
    }
}