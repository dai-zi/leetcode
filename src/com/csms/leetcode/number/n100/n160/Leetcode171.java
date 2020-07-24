package com.csms.leetcode.number.n100.n160;
//Excel表列序号
//简单
public class Leetcode171 {
    public int titleToNumber(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
    public static void main(String[] args) {
    }
}