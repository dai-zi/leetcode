package com.csms.leetcode.number.n1400.n1440;

import java.util.List;

//收集树上所有苹果的最少时间
//中等
public class Leetcode1443 {
public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        //记录节点的父节点编号
        int[] parent = new int[n];
        //记录节点是否被访问
        Boolean[] visit=new Boolean[n];
        for(int i=0;i<n;i++){
            visit[i]=false;
        }
        //以0为根节点初始化
        parent[0]=0;
        visit[0]=true;
        //记录被加入树的节点数量
        int buildnum=1;
        //构建树结构，首先找到以0为根的节点，加入树中，再将以这些节点为父节点的节点加入树中（不一定是先将0为根的节点全部加入后才加入其它节点，但不影响最后结果）
        while(buildnum<n){
            for(int[] edge:edges){
                if(visit[edge[0]]==true){
                    parent[edge[1]]=edge[0];
                    visit[edge[1]]=true;
                    buildnum++;
                }
                else if(visit[edge[1]]==true){
                    parent[edge[0]]=edge[1];
                    visit[edge[0]]=true;
                    buildnum++;
                }
            }
        }
        //重置是否被访问
        for(int i=1;i<n;i++){
            visit[i]=false;
        }
        //记录结果
        int res=0;
        //从有苹果的节点网上遍历，直到遍历到被访问过的节点为止，每次结果加2
        for(int i=0;i<n;i++){
            if(hasApple.get(i)==true){
                int now=i;
                while(visit[now]==false){
                    visit[now]=true;
                    now=parent[now];
                    res+=2;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
    }
}