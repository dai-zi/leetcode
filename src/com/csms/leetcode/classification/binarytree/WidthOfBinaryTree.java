package com.csms.leetcode.classification.binarytree;

import com.csms.leetcode.common.TreeNode;

public class WidthOfBinaryTree {
    class Node {
        int min, max;
        Node next;
    }
    private void calNode(TreeNode node, int val, Node level ){
        if (level.min==0) {
            level.min=val;
            level.max=val;
        } else if (val>level.max) {
            level.max=val;
        }
        if (node.left==null && node.right==null) return;
        if (level.next==null) level.next = new Node();
        if (node.left!=null) calNode(node.left, val*2-1, level.next);
        if (node.right!=null) calNode(node.right, val*2, level.next);
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root==null) return 0;

        Node level = new Node();
        calNode(root, 1, level);
        int k, res=0;
        while (level!=null){
            k = level.max - level.min + 1;
            if (k>res) res = k;
            level = level.next;
        }
        return res;

    }
}
