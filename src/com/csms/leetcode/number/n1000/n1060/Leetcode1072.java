package com.csms.leetcode.number.n1000.n1060;

import java.util.HashMap;
import java.util.Map;

//按列翻转得到最大值等行数
//中等
public class Leetcode1072 {
public int maxEqualRowsAfterFlips(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        boolean firstZero = false;
        int res = 0;
        for (int i = 0, len = matrix.length; i < len; i++) {
            if (matrix[i][0] == 0) {
                firstZero = true;
            } else {
                firstZero = false;
            }
            StringBuilder temp = new StringBuilder();
            for (int j = 0, colLen = matrix[i].length; j < colLen; j++) {
                if (firstZero) {
                    temp.append(matrix[i][j]);
                } else {
                    temp.append((matrix[i][j] ^ 1));
                }
            }
            String tempStr = temp.toString();
            res  = Math.max(map.getOrDefault(tempStr, 0) + 1, res);
            map.put(tempStr, map.getOrDefault(tempStr, 0) + 1);
        }   
        return res;
    }
    public static void main(String[] args) {
    }
}