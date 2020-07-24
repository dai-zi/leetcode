package com.csms.leetcode.number.n1300.n1340;
//制造字母异位词的最小步骤数
//中等
public class Leetcode1347 {
public int minSteps(String s, String t) {
        int [] S=new int[26];
        int [] T=new int[26];
        for (int i=0;i<s.length();i++){
            S[s.charAt(i)-'a']++;
        }
        for (int i=0;i<t.length();i++){
            T[t.charAt(i)-'a']++;
        }
        int ss=0,tt=0;
        for (int i=0;i<26;i++){
            if (S[i]>T[i])
                ss+=S[i]-T[i];
            else
                tt+=T[i]-S[i];
        }
        return Math.min(ss,tt);
    }

    public static void main(String[] args) {
    }
}