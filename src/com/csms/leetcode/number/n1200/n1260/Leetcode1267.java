package com.csms.leetcode.number.n1200.n1260;

import java.util.Arrays;

//统计参与通信的服务器
//中等
public class Leetcode1267 {
public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        DisJoint disJoint = new DisJoint(m + n);
        // 记录总的服务器
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 关联行列
                if (grid[i][j] == 1) {
                    disJoint.union(disJoint.find(i), disJoint.find(m + j));
                    count++;
                }
            }
        }
        // 可通信服务器为总数减去单台服务器的数量
        return count - disJoint.count(2);
    }

    public static void main(String[] args) {
    }

    // 以下是不相交集的常规实现，新增本题所需的统计函数count
    class DisJoint {
        int[] tree;

        DisJoint(int size) {
            this.tree = new int[size];
            Arrays.fill(tree, -1);
        }

        public void union(int root1, int root2) {
            if (tree[root1] >= 0 || tree[root2] >= 0) throw new IllegalArgumentException("not a root");
            if (root1 == root2) return;

            if (tree[root1] <= tree[root2]) {
                tree[root1] += tree[root2];
                tree[root2] = root1;
            } else {
                tree[root2] += tree[root1];
                tree[root1] = root2;
            }
        }

        public int find(int idx) {
            if (tree[idx] < 0) return idx;
            return tree[idx] = find(tree[idx]);
        }
        // 计算尺寸为size的集合个数
        public int count(int size) {
            int count = 0;
            for (int i = 0; i < tree.length; i++) {
                if (tree[i] == -size) count++;
            }
            return count;
        }
    }
}


