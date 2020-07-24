package com.csms.leetcode.number.n1100.n1140;

import com.csms.leetcode.common.TreeNode;

//二叉树着色游戏
//中等
public class Leetcode1145 {
private TreeNode firstPlayerNode = null; //第一个玩家选择的节点
    private int leftChildrenNodeCount = 0; // 第一个玩家选择的节点为基准，左孩子及子孙节点数
    private int rightChildrenNodeCount = 0; // 第一个玩家选择的节点为基准，右孩子及子孙节点数
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (root == null) {
            return false;
        }
        findTreeNode(root, x); // 遍历寻找一号玩家选择的节点
        leftRecursionPreloaderTraversal(firstPlayerNode.left); // 计算一号玩家选择的节点左树区域的节点数
        rightRecursionPreloaderTraversal(firstPlayerNode.right); // 计算一号玩家选择的节点右树区域的节点数

        int parentNodeCount = n - leftChildrenNodeCount - rightChildrenNodeCount - 1; // 计算一号玩家选择的节点父节点区域的节点数
        return parentNodeCount > (n >> 1) || leftChildrenNodeCount > (n >> 1) || rightChildrenNodeCount > (n >> 1);
    }
    
    private void findTreeNode(TreeNode root, int x) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            firstPlayerNode = root;
            return;
        }
        findTreeNode(root.left, x);
        findTreeNode(root.right, x);
    }

    private void leftRecursionPreloaderTraversal(TreeNode root) {
        if (root != null) {
            leftChildrenNodeCount++;
            leftRecursionPreloaderTraversal(root.left);
            leftRecursionPreloaderTraversal(root.right);
        }
    }

    private void rightRecursionPreloaderTraversal(TreeNode root) {
        if (root != null) {
            rightChildrenNodeCount++;
            rightRecursionPreloaderTraversal(root.left);
            rightRecursionPreloaderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
    }
}