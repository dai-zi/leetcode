package com.csms.leetcode.number.n400.n420;
//字符串中的单词数
//简单
public class Leetcode434 {
    public int countSegments(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
    public static void main(String[] args) {
    }
}