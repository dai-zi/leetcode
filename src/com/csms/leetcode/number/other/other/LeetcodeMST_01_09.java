package com.csms.leetcode.number.other.other;
//字符串轮转
//简单
public class LeetcodeMST_01_09 {
public boolean isFlipedString(String s1, String s2) 
    {
        if(s1.length()!=s2.length())return false;
        if(s1.equals(s2))return true;
        s1+=s1;
        return s1.contains(s2);
    }
    public static void main(String[] args) {
    }
}