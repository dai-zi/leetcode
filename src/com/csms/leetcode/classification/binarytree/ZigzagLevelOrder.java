package com.csms.leetcode.classification.binarytree;

import com.csms.leetcode.common.TreeNode;

import java.util.*;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> oneLevel = new ArrayList<>();
        oneLevel.add(root.val);
        boolean needReverse = false;//false´Ó×óÏòÓÒÊä³ö
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode cur = null;
        int curCnt = 0;
        int nextCnt = 1;
        while(queue.size() > 0){
            if(curCnt == 0){
                curCnt = nextCnt;
                nextCnt = 0;
                if(needReverse){
                    Collections.reverse(oneLevel);
                    needReverse = false;
                }else{
                    needReverse = true;
                }
                res.add(oneLevel);
                oneLevel = new ArrayList<>();
            }
            cur = queue.remove();
            curCnt--;
            if(cur.left != null){
                queue.add(cur.left);
                oneLevel.add(cur.left.val);
                nextCnt ++;
            }
            if(cur.right != null){
                queue.add(cur.right);
                oneLevel.add(cur.right.val);
                nextCnt ++;
            }
        }
        return res;
    }
}
