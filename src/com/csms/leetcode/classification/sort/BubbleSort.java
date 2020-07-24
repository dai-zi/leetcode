package com.csms.leetcode.classification.sort;

import com.csms.leetcode.common.ListNode;

import java.util.List;

public class BubbleSort {
    public static void sort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            for(int j=0; j < arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void sortByList(ListNode head){
        if(head.next == null){
            return;
        }else if(head.next.next == null){
            System.out.println(head.next.val);
        }
        int len = 0;
        ListNode tmp = head;
        while(tmp != null){
            len++;
            tmp = tmp.next;
        }

        for (int i = 0; i < len - 1; i++) {
            ListNode curNode = head;
            for (int j = 0; j < len - 1 - i; j++) {
                if (curNode.val > curNode.next.val) {
                    int temp = curNode.val;
                    curNode.val = curNode.next.val;
                    curNode.next.val = temp;
                }
                curNode = curNode.next;
            }
        }
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
        sortByList(head);
        //sort(arr);
    }
}
