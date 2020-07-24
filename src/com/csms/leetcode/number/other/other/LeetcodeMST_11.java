package com.csms.leetcode.number.other.other;
//旋转数组的最小数字
//简单
public class LeetcodeMST_11 {
public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }
    public static void main(String[] args) {
    }
}