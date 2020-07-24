package com.csms.leetcode.number.n500.n520;
//检测大写字母
//简单
public class Leetcode520 {
    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        int index = 0;
        for(int i = 0;i<word.length();i++) {
            if(word.charAt(i)-'A'<=25) {
                cnt++;
                index = i;
            }
        }
        if((cnt==word.length())||(cnt==1&& index ==0)||(cnt==0)) {
            return true;
        }
        if((cnt>1&&cnt<word.length())||(cnt==1&&index!=0)) {
            return false;
        }
        return false;
    }
    public static void main(String[] args) {
    }
}