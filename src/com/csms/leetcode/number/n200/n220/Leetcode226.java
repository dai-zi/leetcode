package com.csms.leetcode.number.n200.n220;

import com.csms.leetcode.common.TreeNode;

//翻转二叉树
//简单
public class Leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
    public static void main(String[] args) {
    }
}