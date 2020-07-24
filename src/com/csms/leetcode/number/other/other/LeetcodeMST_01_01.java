package com.csms.leetcode.number.other.other;
//判定字符是否唯一
//简单
public class LeetcodeMST_01_01 {
public boolean isUnique(String astr) {
        for (int i=0;i<astr.length();i++){
            String s=astr;
            s=s.replace(String.valueOf(s.charAt(i)),"");
            if (s.length()!=astr.length()-1)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
    }
}