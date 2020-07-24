package com.csms.leetcode.number.n1100.n1160;

import com.csms.leetcode.common.TreeNode;

//最大层内元素和
//中等
public class Leetcode1161 {
int n = 10000;
  int[] levelSum = new int[n];

  public void inorder(TreeNode node, int level) {
    if (node != null) {
      inorder(node.left, level + 1);
      levelSum[level] += node.val;
      inorder(node.right, level + 1);
    }
  }
  
  public int maxLevelSum(TreeNode root) {
    inorder(root, 1);

    int maxIdx = 0;
    for (int i = 0; i < n; ++i)
      maxIdx = levelSum[i] > levelSum[maxIdx] ? i : maxIdx;
    return maxIdx;
}

    public static void main(String[] args) {
    }
}