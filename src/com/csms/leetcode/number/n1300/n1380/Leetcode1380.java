package com.csms.leetcode.number.n1300.n1380;

import java.util.ArrayList;
import java.util.List;

//矩阵中的幸运数
//简单
public class Leetcode1380 {
public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList();
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++){
            int min = matrix[i][0];
            int k = 0;
            for(int j = 1; j < n; j++){
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                    k = j;
                }
            }
            int x;
            for(x = 0; x < m; x++){
                if(matrix[x][k] > min) break;
            }
            if(x==m) list.add(min); // x=m表示没有break,该列没有比min大的数;
        }
        return list;

    }
    public static void main(String[] args) {
    }
}