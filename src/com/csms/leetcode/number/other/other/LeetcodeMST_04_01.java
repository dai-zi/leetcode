package com.csms.leetcode.number.other.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//节点间通路
//中等
public class LeetcodeMST_04_01 {
public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
    // 将矩阵转为邻接表
    List<Integer>[] adj= new ArrayList[n];
    for (int[] edge:graph){
        int from=edge[0];
        int to=edge [1];
        if (adj[from]==null)
            adj[from]=new ArrayList<>();
        adj[from].add(to);
    }
    // 建一个函数进行广度遍历
    return hasPath(n,adj,start,target);
}

private boolean hasPath(int n, List<Integer>[] adj, int start, int target){
    // 维护一个队列：从0的链表访问，访问过程中0能到达的节点继续入列
    LinkedList<Integer> queue = new LinkedList<> ();
    queue.offer(start);
    // 维护一个数组：对已经入列的节点，不再重复处理
    boolean[] visited = new boolean [n];
    visited[start]=true;

    while(!queue.isEmpty()){
        int size=queue.size();
        // 不断从队列中取节点得到新的可访问链表，对链表上的可访问节点中判断是否有target
        for(int i = 0; i < size; i++){
            int node = queue.poll();
            List<Integer> nextList = adj [node];
            if (nextList==null){
                continue;
            }
            for (Integer next : nextList){
                // 遍历过程中有target则直接返回true, 否则最终返回false
                if (next==target){
                    return true;
                }
                // 已经入列的节点，不再重复处理
                if (visited[next]){
                    continue;
                }
                // 用数组标记新的节点
                visited [next] =true;
                // 访问过程中0能到达的节点继续入列
                queue.add(next);
            }
        }
    }
    return false;
}

    public static void main(String[] args) {
    }
}