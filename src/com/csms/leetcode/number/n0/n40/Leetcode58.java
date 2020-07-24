package com.csms.leetcode.number.n0.n40;
//最后一个单词的长度
//简单
public class Leetcode58 {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
    public static void main(String[] args) {
    }
}