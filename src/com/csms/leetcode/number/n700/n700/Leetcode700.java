package com.csms.leetcode.number.n700.n700;

import com.csms.leetcode.common.TreeNode;

//二叉搜索树中的搜索
//简单
public class Leetcode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val) return root;

        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
    public static void main(String[] args) {
    }
}