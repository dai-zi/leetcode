package com.csms.leetcode.number.n800.n820;
//相似字符串组
//困难
public class Leetcode839 {
    int n;
    String[] A;
    int[] root;
    public int numSimilarGroups(String[] A) {
        this.n = A.length;
        this.A = A;
        this.root = new int[n];
        for (int i = 0; i < n; i ++) {
            root[i] = i;
        }
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (isSimilar(i, j)) {
                    root[getRoot(j)] = i;
                }
            }
        }
        int res = 0;
        for (int i = 0;i < root.length; i ++) {
            if (root[i] == i) res ++;
        }
        return res;
    }


    int getRoot(int idx) {
        if (root[idx] == idx) return idx;
        return getRoot(root[idx]);
    }

    boolean isSimilar(int i, int j) {
        int cnt = 0;
        if (A[i].length() != A[j].length()) return false;
        for (int k = 0; k < A[i].length(); k ++) {
            if (A[i].charAt(k) != A[j].charAt(k)) {
                cnt ++;
                if (cnt > 2) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
    }
}