package com.csms.leetcode.number.n900.n900;

import com.csms.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//完全二叉树插入器
//中等
public class Leetcode919 {
TreeNode root;
    Deque<TreeNode> deque;
    public Leetcode919(TreeNode root) {
        this.root = root;
        deque = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        // BFS to populate deque
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null || node.right == null)
                deque.offerLast(node);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));
        if (node.left == null)
            node.left = deque.peekLast();
        else {
            node.right = deque.peekLast();
            deque.pollFirst();
        }

        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
    }
}