package com.csms.leetcode.number.other.other;
//交换数字
//中等
public class LeetcodeMST_16_01 {
public int[] swapNumbers(int[] numbers) {
        numbers[1] = numbers[0] + numbers[1];
        numbers[0] = numbers[1] - numbers[0];
        numbers[1] = numbers[1] - numbers[0];
        return numbers;
    }

    public static void main(String[] args) {
    }
}