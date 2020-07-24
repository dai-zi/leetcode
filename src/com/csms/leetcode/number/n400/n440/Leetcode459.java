package com.csms.leetcode.number.n400.n440;
//重复的子字符串
//简单
public class Leetcode459 {
    public boolean repeatedSubstringPattern(String s) {
        for(int i=1;i<s.length();i++){
            if(s.length()%i==0){
                if(judge(s.substring(0,i),s)) return true;
            }
        }
        return false;
    }
    public boolean judge(String sub, String S){
        int len = sub.length();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)!=sub.charAt(i%len)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
    }
}