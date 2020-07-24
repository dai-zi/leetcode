package com.csms.leetcode.number.n1000.n1020;
//飞地的数量
//中等
public class Leetcode1020 {
/**
     * 把边界接触的1都置为0，数圈内1的数量
     *
     * @param A
     * @return
     */
    public static int numEnclaves(int[][] A) {
        // 从上边界搜索
        for (int j = 0; j < A[0].length; j++) {
            int num = A[0][j];
            if (num == 1) {
                expandSearch(A, 0, j, 0);
            }
        }

        // 从左边界搜索
        for (int j = 0; j < A.length; j++) {
            int num = A[j][0];
            if (num == 1) {
                expandSearch(A, j, 0, 1);
            }
        }

        // 从右边界搜索，其实这外层循环可以删除，我就是担心二维数组不是一个标准的，担心每行有长有短，进行一个长度判断
        for (int i = 0; i < A.length; i++) {
            // 第0行最大长度就是有边界
            int rightMax = A[i].length - 1;

            for (int j = 0; j < A.length; j++) {
                int num = A[j][rightMax];
                if (num == 1) {
                    expandSearch(A, j, rightMax, 2);
                }
            }
        }

        // 从下边界搜索
        int downMax = A.length - 1;
        for (int j = 0; j < A[downMax].length; j++) {
            int num = A[downMax][j];
            if (num == 1) {
                expandSearch(A, downMax, j, 3);
            }
        }

        // 最后统计
        int count = 0;
        for (int[] ints : A) {
            for (int num : ints) {
                if (num == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void expandSearch(int[][] A, int x, int y, int currentStartBorder) {
        // 本身置为0
        A[x][y] = 0;

        // 尝试左移动
        int leftTargetIndex = y - 1;
        if (leftTargetIndex >= 0 && currentStartBorder != 1) {
            if (A[x][leftTargetIndex] == 1) {
                A[x][leftTargetIndex] = 0;
                expandSearch(A, x, leftTargetIndex, 4);
            }
        }

        // 右
        int rightTargetIndex = y + 1;
        if (rightTargetIndex < A[x].length && currentStartBorder != 2) {
            if (A[x][rightTargetIndex] == 1) {
                A[x][rightTargetIndex] = 0;
                expandSearch(A, x, rightTargetIndex, 4);
            }
        }
        // 向上
        int upTargetIndex = x - 1;
        if (upTargetIndex >= 0 && currentStartBorder != 0) {
            if (A[upTargetIndex][y] == 1) {
                A[upTargetIndex][y] = 0;
                expandSearch(A, upTargetIndex, y, 4);
            }
        }

        // 下
        int downTargetIndex = x + 1;
        if (downTargetIndex < A.length && currentStartBorder != 3) {
            if (A[downTargetIndex][y] == 1) {
                A[downTargetIndex][y] = 0;
                expandSearch(A, downTargetIndex, y, 4);
            }
        }
    }

    public static void main(String[] args) {
    }
}