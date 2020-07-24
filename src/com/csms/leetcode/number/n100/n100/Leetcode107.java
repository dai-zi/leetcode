package com.csms.leetcode.number.n100.n100;

import com.csms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

//二叉树的层次遍历II
//简单
public class Leetcode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        DFS(root, 0, ans);
        return ans;
    }

    private void DFS(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        // 当前层数还没有元素，先 new 一个空的列表
        if (ans.size() <= level) {
            ans.add(0, new ArrayList<>());
        }
        // 当前值加入
        ans.get(ans.size() - 1 - level).add(root.val);

        DFS(root.left, level + 1, ans);
        DFS(root.right, level + 1, ans);
    }
    public static void main(String[] args) {
    }
}