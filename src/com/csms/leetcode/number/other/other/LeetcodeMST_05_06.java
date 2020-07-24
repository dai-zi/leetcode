package com.csms.leetcode.number.other.other;
//整数转换
//简单
public class LeetcodeMST_05_06 {
public int convertInteger(int A, int B) {
        int temp = A ^ B;
        int count = 0;
        while (temp != 0) {
            temp &= (temp - 1);  // 去掉二进制表示的最右边的1
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
    }
}