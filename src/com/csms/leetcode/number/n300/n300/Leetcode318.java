package com.csms.leetcode.number.n300.n300;
//最大单词长度乘积
//中等
public class Leetcode318 {
    public boolean noCommonLetters(String s1, String s2){
        for (char ch : s1.toCharArray())
            if (s2.indexOf(ch) != -1) return false;
        return true;
    }

    public static void main(String[] args) {
    }
}