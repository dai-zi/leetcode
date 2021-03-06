package com.csms.leetcode.number.n800.n880;

import java.util.Arrays;

//有序队列
//困难
public class Leetcode899 {
    public String orderlyQueue(String S, int K) {
        if (K == 1) {
            String ans = S;
            for (int i = 0; i < S.length(); ++i) {
                String T = S.substring(i) + S.substring(0, i);
                if (T.compareTo(ans) < 0) ans = T;
            }
            return ans;
        } else {
            char[] ca = S.toCharArray();
            Arrays.sort(ca);
            return new String(ca);
        }
    }
    public static void main(String[] args) {
    }
}