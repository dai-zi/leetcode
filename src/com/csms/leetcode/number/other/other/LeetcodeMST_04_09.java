package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//二叉搜索树序列
//困难
public class LeetcodeMST_04_09 {
    public static List<List<Integer>> BSTSequences(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root != null) {
            List<Integer> single = new ArrayList<Integer>();
            List<TreeNode> free = new LinkedList<TreeNode>();
            single.add(root.val);
            addList(root, single, free, res);
        }
        if(res.size() == 0) {
            res.add(new ArrayList<Integer>());
        }
        return res;
    }


    private static  void addList(TreeNode root, List<Integer> single, List<TreeNode> free,  List<List<Integer>> res) {


        if(root == null) {
            return;
        }

        if(root.left != null) {
            free.add(root.left);
        }

        if(root.right != null) {
            free.add(root.right);
        }

        if(free.size() == 0) {
            List<Integer> one = new ArrayList<Integer>();
            for (int i = 0; i < single.size(); i ++) {
                one.add(single.get(i));
            }
            res.add(one);
        }
        for (int i = 0; i < free.size(); i ++) {
            single.add(free.get(i).val);
            TreeNode remove = free.remove(i);
            addList(remove, single, free, res);
            free.add(i, remove);
            single.remove(single.size() - 1);
        }
        if(root.right != null) {
            free.remove(root.right);
        }
        if(root.left != null) {
            free.remove(root.left);
        }
    }
    public static void main(String[] args) {
    }
}