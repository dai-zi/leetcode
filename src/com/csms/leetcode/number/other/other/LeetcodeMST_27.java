package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.TreeNode;

import java.util.Stack;

//二叉树的镜像
//简单
public class LeetcodeMST_27 {
public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>() {{ add(root); }};
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
    public static void main(String[] args) {
    }
}