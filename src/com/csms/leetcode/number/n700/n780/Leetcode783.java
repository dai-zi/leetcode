package com.csms.leetcode.number.n700.n780;

import com.csms.leetcode.common.TreeNode;

//二叉搜索树节点最小距离
//简单
public class Leetcode783 {
Integer prev, ans;
    public int minDiffInBST(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (prev != null)
            ans = Math.min(ans, node.val - prev);
        prev = node.val;
        dfs(node.right);
    }

    public static void main(String[] args) {
    }
}