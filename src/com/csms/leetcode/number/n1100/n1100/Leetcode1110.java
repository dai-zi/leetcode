package com.csms.leetcode.number.n1100.n1100;

import com.csms.leetcode.common.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//删点成林
//中等
public class Leetcode1110 {
class Solution {
    private LinkedList<TreeNode> res = new LinkedList<TreeNode>();
    private HashSet<Integer> delete_set;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        delete_set = new HashSet<>(to_delete.length);
        for (int delete : to_delete) delete_set.add(delete);
        helper(root, true);
        return res;
    }
    
    private boolean helper(TreeNode root, boolean isAdd) {
        if (root != null) {
            if (delete_set.contains(root.val)) {
                if (helper(root.left, true)) root.left = null;
                if (helper(root.right, true)) root.right = null;
                return true;
            }
            if (isAdd) res.add(root);
            if (helper(root.left, false)) root.left = null;
            if (helper(root.right, false)) root.right = null;
        }
        return false;
    }
}
    public static void main(String[] args) {
    }
}