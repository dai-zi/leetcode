package com.csms.leetcode.number.n1400.n1400;
//构造K个回文字符串
//中等
public class Leetcode1400 {
public boolean canConstruct(String s, int k) {
            if(s.length()<k)return false;
            int c[]=new int[26];
            for(char cc:s.toCharArray())
                c[cc-'a']++;
            int odd=0;
            for(int i=0;i<26;i++)
                if((c[i]&1)==1)odd++;
            return !(odd>k);
        }

    public static void main(String[] args) {
    }
}