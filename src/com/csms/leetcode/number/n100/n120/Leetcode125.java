package com.csms.leetcode.number.n100.n120;
//验证回文串
//简单
public class Leetcode125 {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] charArray = s.toCharArray();

        while (i < j) {
            // 将i和j指向第一个是字母和数字的位置
            while (!Character.isLetterOrDigit(charArray[i]) && i < j) {
                i++;
            }
            while (!Character.isLetterOrDigit(charArray[j]) && i < j) {
                j--;
            }

            // 如果不相等，就返回false
            if ((int) Character.toLowerCase(charArray[i]) != (int) Character.toLowerCase(charArray[j])) {
                return false;
            }

            // 将i和j向中间移动
            i++; j--;
        }

        return true;
    }
    public static void main(String[] args) {
    }
}