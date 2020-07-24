package com.csms.leetcode.number.n600.n680;
//重复叠加字符串匹配
//简单
public class Leetcode686 {
    public int repeatedStringMatch(String A, String B) {
        int i = 1;
        StringBuilder s = new StringBuilder(A);
        int blength = B.length();
        while(s.length() < blength){
            s.append(A);
            i++;
        }
        return s.lastIndexOf(B) == -1?((s.append(A)).lastIndexOf(B)==-1?-1:i+1):i;
    }

    public static void main(String[] args) {
    }
}