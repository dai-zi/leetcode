package com.csms.leetcode.number.n700.n740;

import com.csms.leetcode.common.TreeNode;

//寻找比目标字母大的最小字母
//简单
public class Leetcode744 {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c: letters)
            if (c > target) return c;
        return letters[0];
    }

    public static void main(String[] args) {
    }
}