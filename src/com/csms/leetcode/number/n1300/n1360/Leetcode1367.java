package com.csms.leetcode.number.n1300.n1360;

import com.csms.leetcode.common.ListNode;
import com.csms.leetcode.common.TreeNode;

//二叉树中的列表
//中等
public class Leetcode1367 {
public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null) return false;
        if (head.val == root.val) return isSubPathLoop(head.next, root.left) || isSubPathLoop(head.next, root.right) || isSubPath(head, root.left) || isSubPath(head, root.right);
        else return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean isSubPathLoop(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val == root.val) 
            return isSubPathLoop(head.next, root.left) || isSubPathLoop(head.next, root.right);
        else 
            return false; 
    }
    public static void main(String[] args) {
    }
}