package com.csms.leetcode.number.other.other;
//排序矩阵查找
//中等
public class LeetcodeMST_10_09 {
public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length-1;
        int y = 0;
        while(x>=0 && x<=matrix.length-1 && y>=0 && y<=matrix[0].length-1){
            if(target > matrix[x][y]){
                y++;
                continue;
            }
            if(target < matrix[x][y]){
                x--;
                continue;
            }
            if(target == matrix[x][y]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
    }
}