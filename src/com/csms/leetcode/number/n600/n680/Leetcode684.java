package com.csms.leetcode.number.n600.n680;
//冗余连接
//中等
public class Leetcode684 {
    private int find(int[] parent, int x) {
        int node = x;
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    private void union(int[] parent, int x, int y) {
        int parentX = find(parent, x);
        int parentY = find(parent, y);
        if (parentX != parentY) {
            parent[parentY] = parentX;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        int[] parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (find(parent, edge[0]) == find(parent, edge[1])) {
                return edge;
            } else {
                union(parent, edge[0], edge[1]);
            }
        }

        return new int[0];
    }
    public static void main(String[] args) {
    }
}