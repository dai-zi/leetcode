package com.csms.leetcode.number.n1200.n1260;

import com.csms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//在受污染的二叉树中查找元素
//中等
public class Leetcode1261 {
private List<Integer> list;
    public Leetcode1261(TreeNode root) {
        list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        root.val=0;
        queue.offer(root);
        while (!queue.isEmpty()){
            root=queue.poll();
            list.add(root.val);
            if (root.left!=null){
                root.left.val=(root.val<<1)+1;
                queue.offer(root.left);
            }
            if (root.right!=null){
                root.right.val=(root.val<<1)+2;
                queue.offer(root.right);
            }

        }

    }

    public boolean find(int target) {
        int left=0;
        int right=list.size()-1;
        while (left<=right){
            int mid=left+((right-left)>>1);
            if (list.get(mid)==target){
                return true;
            }else if (list.get(mid)>target){
                right=mid-1;
                continue;
            }else {
                left=mid+1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
    }
}