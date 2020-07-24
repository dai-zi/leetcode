package com.csms.leetcode.number.n600.n680;
//冗余连接II
//困难
public class Leetcode685 {
    int[] father;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        father = new int[edges.length + 1];
        int[] result = null;
        for(int i = 1; i <= edges.length; i++) {
            father[i] = i;
        }
        int finalF = -1;
        int ringA = -1, ringB = -1;
        for(int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            int fa = find(a), fb = find(b);
            if(fa == fb) {
                if(ringA != -1 && ringB != -1) {
                    result = new int[]{father[ringB], ringB};
                } else {
                    result = new int[]{a, b};
                }
                finalF = fa;
            }else if (fb != b) {
                ringA = a;
                ringB = b;
            } else {
                merge(a, b);
            }
        }
        if(ringA != -1) {
            if(finalF != -1 && find(ringA) != finalF) {
                return new int[]{father[ringB], ringB};
            }
            return new int[]{ringA, ringB};
        }
        return  result;
    }

    int find(int x) {
        return father[x] == x ? x : find(father[x]);
    }

    void merge(int x, int y) {
        father[y] = x;
    }

    public static void main(String[] args) {
    }
}