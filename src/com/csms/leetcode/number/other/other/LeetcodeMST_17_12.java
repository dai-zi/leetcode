package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.TreeNode;

//BiNode
//简单
public class LeetcodeMST_17_12 {
// 保存下一个节点
    TreeNode next = null;
    // 中序遍历，但是先右，中，最后左 
    public TreeNode convertBiNode(TreeNode root) {
        if(root == null)
            return null;
        convertBiNode(root.right);
        // right设置为下一个节点
        root.right = next;
        // 把当前节点设置为下一个节点
        next = root;
        // 遍历左子树
        convertBiNode(root.left);
        // 把左子树设置为null
        root.left = null;
        // 返回头节点
        return next;
    }
    public static void main(String[] args) {
    }
}