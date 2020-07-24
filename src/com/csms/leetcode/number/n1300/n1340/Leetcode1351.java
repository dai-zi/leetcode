package com.csms.leetcode.number.n1300.n1340;
//统计有序矩阵中的负数
//简单
public class Leetcode1351 {
public int countNegatives(int[][] grid) {
    int count = 0, m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; i++) {
        int[] row = grid[i];
        if (row[n - 1] >= 0) continue; // 整行非负，跳过
        if (row[0] < 0) { // 整行负数
            count += (m - i) * n; // 后面的行也计入
            break; // 无需再继续遍历
        }
        int first = _binarySearch(row); // 当前行二分查找第一个小于 0 的数的索引
        count += n - first;
    }
    return count;
}

// 查找第一个小于 0 的数的索引
private int _binarySearch(int[] arr) {
    int begin = 0, end = arr.length;
    while (begin < end) {
        int mid = begin + ((end - begin) >> 1);
        if (arr[mid] >= 0) begin = mid + 1;
        else { // 负数之后，还要再判断前一个不是负数
            if (arr[mid - 1] >= 0) return mid;
            end = mid;
        }
    }
    return begin;
}
    public static void main(String[] args) {
    }
}