package com.csms.leetcode.number.n1000.n1000;

import java.util.ArrayList;

//至少有1位重复的数字
//困难
public class Leetcode1012 {
    public int numDupDigitsAtMostN(int N) {
        ArrayList<Integer> L = new ArrayList<>();
        for (int x = N + 1; x > 0; x /= 10)
            L.add(0, x % 10);
        int res = 0, n = L.size();
        // 考虑 XXX形式的数
        for (int i = 1; i < n; ++i)
            res += 9 * A(9, i - 1);
        boolean[] seen = new boolean[10];
        for (int i = 0; i < n; ++i) {
            for (int j = i > 0 ? 0 : 1 ; j < L.get(i); ++j) {
                // 遍历当前位置i的所有可能
                if (!seen[j]) {
                    res += A(9 - i, n - i - 1);
                }
            }
            // 剪枝 如果 N = 4456; 当遍历到 44XX， 没必要再向后遍历了，因为一定是重复的
            if (seen[L.get(i)]) { break; }
            seen[L.get(i)] = true;
            // 将当前位置的数组放入seen中，防止后边数字与其重复
        }
        return N - res;
    }

    // 排列组合数计算
    public int A(int n, int m) {
        return m == 0 ? 1 : A(n, m - 1) * (n - m + 1);
    }
    public static void main(String[] args) {
    }
}