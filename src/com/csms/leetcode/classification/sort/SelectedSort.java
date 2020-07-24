package com.csms.leetcode.classification.sort;

import com.csms.leetcode.common.ListNode;

import java.util.List;

public class SelectedSort {
    public static void sort(int[] arr){
        int len = arr.length;
        for(int i = 0;i<len-1;i++){
            int min = i;//记录最小值的位置
            for(int j = i+1;j<len;j++){
                if(arr[j]<arr[min]){//如果有更小的，则更新最小值的位置
                    min = j;
                }
            }
            //如果最小值位置改变了（不是i了），则交换，就是将最小值从后面换到前面
            if(min!=i){
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void sortByList(ListNode head){
        if(head == null || head.next == null) return;
        ListNode pStart = new ListNode(0);//添加辅助的头节点
        pStart = head;
        ListNode tailNode = pStart;//指向已排好序的尾部节点

        while(tailNode.next!=null){
            ListNode minNode = tailNode.next;
            ListNode p = tailNode.next.next;
            //寻找未排序部分的最小节点
            while(p!=null){
                if(p.val<minNode.val){
                    minNode = p;
                }
                p = p.next;
            }
            //交换值
            int temp = tailNode.next.val;
            tailNode.next.val = minNode.val;
            minNode.val = temp;

            tailNode = tailNode.next;
        }
        //head = pStart.next;
        head = head.next;
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] arr={6,3,8,2,9,1};
        ListNode head = new ListNode(0);
        head.next = new ListNode(6);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next = new ListNode(1);
        //sortByList(head);
        sort(arr);
    }
}
