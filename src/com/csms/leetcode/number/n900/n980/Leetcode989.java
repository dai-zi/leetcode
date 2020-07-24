package com.csms.leetcode.number.n900.n980;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//数组形式的整数加法
//简单
public class Leetcode989 {
public List<Integer> addToArrayForm(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
    }
}