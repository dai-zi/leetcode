package com.csms.leetcode.number.n1200.n1220;
//分割平衡字符串
//简单
public class Leetcode1221 {
public int balancedStringSplit(String s) {
        int num = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'L')
                num++;
            else
                num--;
            if(num == 0)
                res++;
        }
        return res;
    }
    public static void main(String[] args) {
    }
}