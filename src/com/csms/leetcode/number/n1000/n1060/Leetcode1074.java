package com.csms.leetcode.number.n1000.n1060;

import java.util.HashMap;

//元素和为目标值的子矩阵数量
//困难
public class Leetcode1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            for (int k = j; k < n; k++) {
                hmap.clear();
                hmap.put(0, 1);
                int sum = 0;
                for (int i = 0; i < m; i++) {
                    if (j > 0) {
                        sum += matrix[i][k] - matrix[i][j-1];
                    } else {
                        sum += matrix[i][k];
                    }
                    if (hmap.containsKey(sum - target)) {
                        res += hmap.get(sum - target);
                    }
                    hmap.put(sum, hmap.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
    }
}