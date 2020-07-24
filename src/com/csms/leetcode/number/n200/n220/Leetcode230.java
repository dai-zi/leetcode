package com.csms.leetcode.number.n200.n220;

import com.csms.leetcode.common.TreeNode;

import java.util.ArrayList;

//二叉搜索树中第K小的元素
//中等
public class Leetcode230 {
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    public static void main(String[] args) {
    }
}