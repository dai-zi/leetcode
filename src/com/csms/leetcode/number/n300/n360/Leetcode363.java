package com.csms.leetcode.number.n300.n360;
//矩形区域不超过K的最大数值和
//困难
public class Leetcode363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                //
                if(j>0)
                    matrix[i][j]+=matrix[i][j-1];
            }
        }//按行求和
        int max=Integer.MIN_VALUE;
        int sum;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++) {
                //取出矩阵每一个点作为窗口起始点

                //滑动窗口
                for (int l = j; l < n; l++) {
                    sum = 0;
                    for (int h = i; h < m; h++) {//h代表窗口滑动的行数
                        if (j == 0)
                            sum += matrix[h][l];
                        else
                            sum += matrix[h][l] - matrix[h][j - 1];
                        if (sum <=k && sum > max)
                            max = sum;
                    }
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
    }
}