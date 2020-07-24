package com.csms.leetcode.number.n1300.n1360;

import com.csms.leetcode.common.TreeNode;

//二叉树中的最长交错路径
//中等
public class Leetcode1372 {
private int maxPath = 0;

  public int longestZigZag(TreeNode root) {
    dfs(root);
    return maxPath;
  }

  private int[] dfs(TreeNode root) {
    int[] res = new int[2];
    if (root == null) {
      res[0] = -1;
      res[1] = -1;
     return res;
    }
    int[] left = dfs(root.left);
    int[] right = dfs(root.right);
    res[0] = 1 + left[1];
    res[1] = 1 + right[0];
    maxPath = Math.max(maxPath, Math.max(res[0], res[1]));
    return res;
  }
    public static void main(String[] args) {
    }
}