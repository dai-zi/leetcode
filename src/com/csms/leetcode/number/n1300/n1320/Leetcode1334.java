package com.csms.leetcode.number.n1300.n1320;

import java.util.Arrays;

//阈值距离内邻居最少的城市
//中等
public class Leetcode1334 {
public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] map = new int[n][n];
        final int INF = 0x3f3f3f3f;
        //init map
        for (int[] ints : map) {
            Arrays.fill(ints, INF);
        }
        for (int i = 0; i < n; i++) {
            map[i][i] = 0;
        }
        for (int[] e : edges) {
            map[e[0]][e[1]] = map[e[1]][e[0]] = e[2];
        }
        int res = 0;
        int MIN = n + 1;

        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            boolean[] set = new boolean[n];
            for (int v = 0; v < n; v++) {
                dist[v] = map[i][v];
            }
            dist[i] = 0;
            set[i] = true;
            for (int j = 0; j < n - 1; j++) {
                int min = INF;
                int start = i;
                for (int k = 0; k < n; k++) {
                    if (!set[k] && dist[k] < min) {
                        min = dist[k];
                        start = k;
                    }
                }
                set[start] = true;
                for (int k = 0; k < n; k++) {
                    if (!set[k] && dist[k] > dist[start] + map[start][k]) {
                        dist[k] = dist[start] + map[start][k];
                    }
                }
            }
            int temp = 0;
            for (int j = 0; j < dist.length; j++) {
                if (dist[j] <= distanceThreshold) {
                    temp++;
                }
            }
            if (temp <= MIN) {
                MIN = temp;
                res = i;
            }
        }
        return res;
    }
	
	public static int findTheCity1(int n, int[][] edges, int distanceThreshold) {
        int[][] map = new int[n][n];

        //init
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        //get map 
        for (int[] e : edges) {
            map[e[0]][e[1]] = map[e[1]][e[0]] = e[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != k && j != k && map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }

        //get res
        int min = n + 1;
        int res = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && map[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (min >= count) {
                min = count;
                res = i;
            }
        }
        return res;
    }
    public static void main(String[] args) {
    }
}