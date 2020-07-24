package com.csms.leetcode.number.n300.n380;

import com.csms.leetcode.common.ListNode;

import java.util.Random;

//链表随机节点
//中等
public class Leetcode382 {
    ListNode root;
    Random random = new Random();
    public Leetcode382(ListNode head) {
        this.root = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode head = root;
        //因为返回一个值 所以 蓄水池 容量为1
        //蓄水池的水 就是 链表中的每个值.
        int[] res = {-1};
        int count = 0; //水的数量
        boolean isFull = false; //蓄水池是否已满
        while(head!=null){
            count++;  //数量加1;
            if(!isFull){
                res[0] = head.val;
                isFull = true; //将蓄水池 灌满  设置isFull为true;
            } else{
                //蓄水池代码的模板，直接套用。
                int i = random.nextInt(count);
                if(i<1) res[0] = head.val;
            }
            head = head.next;

        }
        return res[0];
    }
    public static void main(String[] args) {
    }
}