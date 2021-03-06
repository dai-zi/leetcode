package com.csms.leetcode.number.n600.n640;

import com.csms.leetcode.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

//两数之和IV_输入BST
//简单
public class Leetcode653 {
    public boolean findTarget(TreeNode root, int k) {
        Set< Integer > set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    public static void main(String[] args) {
    }
}