package com.csms.leetcode.number.n1300.n1300;
//连通网络的操作次数
//中等
public class Leetcode1319 {
int[] father;
    int[] sz;
    int num;

    public int find(int p) {
        if (p != father[p]) {
            p = find(father[p]);
        }
        return p;
    }
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        num -= 1;
        if (sz[i] < sz[j]) {
            father[i] = j;
            sz[j] += sz[i];
        } else {
            father[j] = i;
            sz[i] += sz[j];
        }
    }

    public void initUF(int n) {
        father = new int[n];
        sz = new int[n];
        num = n;
        for (int i = 0; i < n; i++) {
            father[i] = i;
            sz[i] = 1;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        initUF(n);
        // 多余的线缆数量
        int cnt = 0;
        for (int[] c : connections) {
            int f = c[0], t = c[1];
            // 两个点已经连通，不需要这个线缆
            if (find(f) == find(t)) {
                cnt += 1;
                continue;
            }
            union(f, t);
        }
        // 所需要的线缆数量
        int cnt2 = num - 1;
        if (cnt < cnt2) {
            return -1;
        }
        return cnt2;
    }

    public static void main(String[] args) {
    }
}