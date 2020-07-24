package com.csms.leetcode.number.n900.n960;

import com.csms.leetcode.common.TreeNode;

//在二叉树中分配硬币
//中等
public class Leetcode979 {
int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }

    public static void main(String[] args) {
    }
}