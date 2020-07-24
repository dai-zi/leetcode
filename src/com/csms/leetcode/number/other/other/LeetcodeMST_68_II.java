package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.TreeNode;

//二叉树的最近公共祖先
//简单
public class LeetcodeMST_68_II {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

    public static void main(String[] args) {
    }
}