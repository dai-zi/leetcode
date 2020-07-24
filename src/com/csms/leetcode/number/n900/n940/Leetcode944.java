package com.csms.leetcode.number.n900.n940;
//删列造序
//简单
public class Leetcode944 {
public int minDeletionSize(String[] A) {
        int ans = 0;
        for (int c = 0; c < A[0].length(); ++c)
            for (int r = 0; r < A.length - 1; ++r)
                if (A[r].charAt(c) > A[r+1].charAt(c)) {
                    ans++;
                    break;
                }

        return ans;
    }
    public static void main(String[] args) {
    }
}