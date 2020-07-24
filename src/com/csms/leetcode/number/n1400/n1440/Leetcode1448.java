package com.csms.leetcode.number.n1400.n1440;

import com.csms.leetcode.common.TreeNode;

import java.util.*;

//统计二叉树中好节点的数目
//中等
public class Leetcode1448 {
static class diyNode{
        TreeNode node;
        long index; //当前节点编号
        diyNode(TreeNode node,long index){
            this.node =node;
            this.index =index;
        }
    }
    public static int goodNodes(TreeNode root) {
        Map<Long,Integer> max = new HashMap<>();
        Queue<diyNode> queue = new ArrayDeque<>();
        queue.add(new diyNode(root,1));
        max.put(1l,root.val);

        //第一次遍历，记录最大值
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                diyNode poll = queue.poll();

                if (poll.node.left !=null){
                    max.put((long) (poll.index*2),Math.max(max.get(Math.max(poll.index,1)),poll.node.left.val));
                    queue.add(new diyNode(poll.node.left,poll.index*2));
                }if (poll.node.right!=null){
                    //System.out.println(dep+1);
                    max.put((long) (poll.index*2+1),Math.max(max.get(Math.max(poll.index,1)),poll.node.right.val));
                    queue.add(new diyNode(poll.node.right,poll.index*2+1));
                }
            }
        }



        int res =1;
        queue = new LinkedList<>();
        queue.add(new diyNode(root,1));

        //第二次遍历，进行比较累加
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                diyNode poll = queue.poll();
                if (poll.node.left !=null){
                    if (poll.node.left.val>=max.get(poll.index)){
                        res++;
                        // System.out.println("left:"+poll.node.left.val+",index:"+poll.index);
                    };
                    queue.add(new diyNode(poll.node.left,poll.index*2));
                }if (poll.node.right!=null){
                    if (poll.node.right.val>=max.get(poll.index)){
                        res++;
                        // System.out.println("right:"+poll.node.right.val+",index:"+poll.index);
                    }
                    queue.add(new diyNode(poll.node.right,poll.index*2+1));
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
    }
}