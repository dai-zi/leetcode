package com.csms.leetcode.number.other.other;

import com.csms.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.Comparator;

//分割链表
//中等
public class LeetcodeMST_02_04 {
public ListNode partition(ListNode head, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        //除了与x相等的元素，先排序
        while (head != null) {
            int val = head.val;
            if (val == x) {
                count++;
                head = head.next;
                continue;
            }
            list.add(val);
            head = head.next;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        //与x相等的放在最后
        while (count > 0) {
            list.add(x);
            count--;
        }
        //构造结果
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        for (int val : list) {
            ListNode node = new ListNode(val);
            cur.next = node;
            cur = cur.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
    }
}