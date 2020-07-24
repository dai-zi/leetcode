package com.csms.leetcode.number.n1300.n1320;

import com.csms.leetcode.common.TreeNode;

//分裂二叉树的最大乘积
//中等
public class Leetcode1339 {
double ans = Double.MIN_VALUE;
    double allSum;
    double nodeSum;
    public int maxProduct(TreeNode root) {
        allSum = sum(root);
        dfs(root);
        return (int)(ans % (int)(1e9 + 7));
    }

    public double sum(TreeNode node){
        if(node == null) return 0;
        return node.val + sum(node.left) + sum(node.right);
    }

    public double dfs(TreeNode node){
        if(node == null)    return 0 ;
        nodeSum = node.val + dfs(node.left) + dfs(node.right);
        ans = Math.max(ans, (allSum - nodeSum) * nodeSum);
        return nodeSum;
    }

    public static void main(String[] args) {
    }
}