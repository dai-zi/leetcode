package com.csms.leetcode.number.n1100.n1140;
//段式回文
//困难
public class Leetcode1147 {
    public int longestDecomposition(String text) {
        int i = 0, j = text.length() - 1;
        int ans = 0;
        int i0 = 0, j0 = text.length() - 1, k = 0;
        while (i < j) {
            while (i < j) {
                if (text.charAt(i++) == text.charAt(j)) {
                    break;
                }
            }
            k = i--;
            while (i >= i0) {
                if (text.charAt(j) != text.charAt(i)) {
                    break;
                }
                i--;
                j--;
            }
            if (i < i0) {
                ans += 2;
                i0 = k;
            } else {
                j = j0;
            }
            i = k;
            j0 = j;
        }
        ans = i0 > j0 ? ans : ans + 1;
        return ans;
    }

    public static void main(String[] args) {
    }
}