package com.csms.leetcode.number.n900.n960;

import com.csms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

//单值二叉树
//简单
public class Leetcode965 {
List<Integer> vals;
    public boolean isUnivalTree(TreeNode root) {
        vals = new ArrayList();
        dfs(root);
        for (int v: vals)
            if (v != vals.get(0))
                return false;
        return true;
    }

    public void dfs(TreeNode node) {
        if (node != null) {
            vals.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }

    public static void main(String[] args) {
    }
}