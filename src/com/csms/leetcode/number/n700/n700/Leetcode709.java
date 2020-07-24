package com.csms.leetcode.number.n700.n700;
//转换成小写字母
//简单
public class Leetcode709 {
    public String toLowerCase(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] += 'a' - 'A';
            }
        }
        return String.valueOf(arr);
    }
    public static void main(String[] args) {
    }
}