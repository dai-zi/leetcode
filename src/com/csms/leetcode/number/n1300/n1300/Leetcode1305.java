package com.csms.leetcode.number.n1300.n1300;

import com.csms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//两棵二叉搜索树中的所有元素
//中等
public class Leetcode1305 {
private List<Integer> ansList;

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        ansList.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ansList = new ArrayList<>();
        dfs(root1);
        dfs(root2);
        Collections.sort(ansList);
        return ansList;
    }

    public static void main(String[] args) {
    }
}