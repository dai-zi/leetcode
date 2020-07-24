package com.csms.leetcode.number.n1100.n1160;

import java.util.ArrayList;
import java.util.List;

//构建回文串检测
//中等
public class Leetcode1177 {
public List<Boolean> canMakePaliQueries2(String s, int[][] queries) {
        int n = s.length();
        int[][] count = new int[n][26];

        count[0][s.charAt(0) - 'a']++;
        for (int i = 1; i < n; ++i) {
            count[i][s.charAt(i) - 'a']++;
            for (int j = 0; j < 26; ++j) {
                count[i][j] += count[i - 1][j];
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0], right = query[1], k = query[2];
            if (k >= right - left + 1) {
                res.add(true);
                continue;
            }
            int modify = 0;
            for (int i = 0; i < 26; ++i) {
                int p = left == 0 ? count[right][i] : count[right][i] - count[left - 1][i];
                if (p > 0) {
                    if (p % 2 == 1) {
                        modify++;
                    }
                }
            }
            if ((modify / 2 <= k) || modify == 0 || (modify == 1 && k == 0)) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}