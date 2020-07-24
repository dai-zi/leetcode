package com.csms.leetcode.number.n1300.n1380;
//最长快乐前缀
//困难
public class Leetcode1392 {
    private static final long P = 805306457;
    private static final long MOD = (int) (1e9+7);
    private long[] hash;
    private long[] power;
    private char[] arr;

    public Leetcode1392(char[] arr) {
        this.arr = arr;
        int len = arr.length;
        hash = new long[len];
        power = new long[len];
        calcHashAndPower();
    }

    private void calcHashAndPower() {
        hash[0] = arr[0];
        power[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            hash[i] = (hash[i-1] * P + arr[i]) % MOD;
            power[i] = (power[i-1] * P) % MOD;
        }
    }

    private long getSubStrHash(int l, int r) {
        if (l == 0) {
            return hash[r];
        }
        return ((hash[r] - power[r-l+1] * hash[l-1]) % MOD + MOD) % MOD;
    }



    public String longestPrefix(String s) {
        char[] arr = s.toCharArray();
        Leetcode1392 strHash = new Leetcode1392(arr);
        int len = arr.length;

        for (int i = len - 2; i >= 0; i--) {
            long prefix = strHash.getSubStrHash(0, i);
            long suffix = strHash.getSubStrHash(len - i - 1, len - 1);
            if (prefix == suffix) {
                return s.substring(0, i + 1);
            }
        }

        return "";
    }
    public static void main(String[] args) {
    }
}