package com.csms.leetcode.number.n900.n920;
//使括号有效的最少添加
//中等
public class Leetcode921 {
public int minAddToMakeValid(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }

    public static void main(String[] args) {
    }
}