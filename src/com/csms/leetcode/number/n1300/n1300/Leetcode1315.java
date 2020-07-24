package com.csms.leetcode.number.n1300.n1300;

import com.csms.leetcode.common.TreeNode;

//祖父节点值为偶数的节点和
//中等
public class Leetcode1315 {
int res;

    public int sumEvenGrandparent(TreeNode root) {
        
        res = 0;
        helper(null, null, root);
        return res;
    }

    private void helper(TreeNode grandP, TreeNode father, TreeNode node) {
        if(node == null) return;

        if(grandP != null && grandP.val % 2 == 0) {
            res += node.val;
        }
        
        helper(father, node, node.left);
        helper(father, node, node.right);
    }

    public static void main(String[] args) {
    }
}