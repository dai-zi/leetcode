package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.TreeNode;

//对称的二叉树
//简单
public class LeetcodeMST_28 {
public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
    public static void main(String[] args) {
    }
}