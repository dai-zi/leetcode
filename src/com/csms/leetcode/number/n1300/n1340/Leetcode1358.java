package com.csms.leetcode.number.n1300.n1340;
//包含所有三种字符的子字符串数目
//中等
public class Leetcode1358 {
public int numberOfSubstrings(String s) {
        int countA = 0, countB = 0, countC = 0,count = 0;
        int start = 0;
        for(int i = 0; i <= s.length(); i++) {
            if (countA > 0 && countB > 0 && countC > 0) {
                count += s.length() - i + 1;
                switch(s.charAt(start++)) {
                    case 'a': countA--; i--; break;
                    case 'b': countB--; i--; break;
                    case 'c': countC--; i--; break;
                }
                
            } else if (i < s.length()){
                switch(s.charAt(i)) {
                    case 'a': countA++; break;
                    case 'b': countB++; break;
                    case 'c': countC++; break;
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
    }
}