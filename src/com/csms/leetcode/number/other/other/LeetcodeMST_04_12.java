package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.TreeNode;

import java.util.HashMap;

//求和路径
//中等
public class LeetcodeMST_04_12 {
public int pathSum(TreeNode root, int sum) {
        //初始化，根节点设置一条路径
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        if(root == null) return 0;
        //dfs树的性质：每条路径只遍历唯一一遍
        //用map记录每条路径的和
        return dfs_count(root, 0, sum, map);
    }
    private int dfs_count(TreeNode root, int routeSum, int target, HashMap<Integer, Integer> map){
        //计算路径和
        routeSum += root.val;
        int res = 0;
        //获取当前节点为终点，满足条件的路径
        int cnt = map.getOrDefault(routeSum - target, 0);
        //添加当前节点路径和
        map.put(routeSum, map.getOrDefault(routeSum, 0) + 1);
        res = cnt ;
        //计算该路径的下一个节点的可能结果
        if(root.left != null) res += dfs_count(root.left, routeSum, target, map);
        if(root.right != null) res += dfs_count(root.right, routeSum, target, map);
        //该节点遍历完成后，抛弃以该节点为终点的路径
        map.put(routeSum, map.getOrDefault(routeSum, 0) - 1);
        return res;
    }

    public static void main(String[] args) {
    }
}