package com.csms.leetcode.number.n300.n340;
//反转字符串
//简单
public class Leetcode344 {
    public void reverseString(char[] s) {
        // 左右双指针
        int left = 0;
        int right = s.length - 1;
        // 交换元素的临时变量 temp
        char temp;

        while (left < right){
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
    public static void main(String[] args) {
    }
}