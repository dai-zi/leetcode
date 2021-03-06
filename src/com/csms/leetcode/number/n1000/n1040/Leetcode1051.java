package com.csms.leetcode.number.n1000.n1040;
//高度检查器
//简单
public class Leetcode1051 {
public int heightChecker(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
    }
}