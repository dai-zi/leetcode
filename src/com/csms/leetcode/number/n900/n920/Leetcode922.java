package com.csms.leetcode.number.n900.n920;
//按奇偶排序数组II
//简单
public class Leetcode922 {
public int[] sortArrayByParityII(int[] A) {
        int N = A.length;
        int[] ans = new int[N];

        int t = 0;
        for (int x: A) if (x % 2 == 0) {
            ans[t] = x;
            t += 2;
        }

        t = 1;
        for (int x: A) if (x % 2 == 1) {
            ans[t] = x;
            t += 2;
        }

        return ans;
    }

    public static void main(String[] args) {
    }
}