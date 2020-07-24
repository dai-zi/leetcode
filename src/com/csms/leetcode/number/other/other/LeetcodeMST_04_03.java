package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.ListNode;
import com.csms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//特定深度节点链表
//中等
public class LeetcodeMST_04_03 {
public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null) {
            return null;
        }
        List<ListNode> res = new ArrayList<ListNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tree);
        while (! queue.isEmpty()) {
            int size = queue.size();
            ListNode head = null;
            ListNode rear = null;
            for(int i = 0; i < size; i ++) {
                
                TreeNode poll = queue.poll();
                
                if(i == 0) {
                    head = rear = new ListNode(poll.val);
                }else {
                    ListNode cur = new ListNode(poll.val);
                    rear = rear.next = cur;
                }
                
                if(poll.left != null) {
                    queue.add(poll.left);
                }
                if(poll.right != null) {
                    queue.add(poll.right);
                }
            }
            res.add(head);
        }
        return res.toArray(new ListNode[0]);
    }

    public static void main(String[] args) {
    }
}