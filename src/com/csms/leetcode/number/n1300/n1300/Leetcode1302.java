package com.csms.leetcode.number.n1300.n1300;

import com.csms.leetcode.common.TreeNode;

//层数最深叶子节点的和
//中等
public class Leetcode1302 {
private int sum  = 0;
    private int deepestLevel = 0;

    public int deepestLeavesSum(TreeNode root) {
        find(0, root);
        return sum;
    }

    private void find(int curLevel, TreeNode node){
        if(node == null){
            return;
        }
        curLevel++;
        if(curLevel > deepestLevel){
            deepestLevel = curLevel;
            sum = node.val;
        }else if(curLevel == deepestLevel){
            sum += node.val;
        }

        find(curLevel, node.left);
        find(curLevel, node.right); 
    }

    public static void main(String[] args) {
    }
}