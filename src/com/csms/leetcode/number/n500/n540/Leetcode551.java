package com.csms.leetcode.number.n500.n540;
//学生出勤记录I
//简单
public class Leetcode551 {
    public boolean checkRecord(String s) {
        int count=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='A')
                count++;
        return count<2 && s.indexOf("LLL")<0;
    }

    public static void main(String[] args) {
    }
}