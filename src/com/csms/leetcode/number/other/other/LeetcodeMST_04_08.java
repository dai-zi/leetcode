package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.TreeNode;

//首个共同祖先
//中等
public class LeetcodeMST_04_08 {
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root == p || root == q) {
            return root;
        } else {
            TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
            if(leftNode != null && rightNode != null) {
                return root;
            }else {
                return leftNode == null ? rightNode : leftNode;
            }
        }
    }

    public static void main(String[] args) {
    }
}