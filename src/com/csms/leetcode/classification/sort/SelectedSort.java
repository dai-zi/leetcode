package com.csms.leetcode.classification.sort;

import com.csms.leetcode.common.ListNode;

import java.util.List;

public class SelectedSort {
    public static void sort(int[] arr){
        int len = arr.length;
        for(int i = 0;i<len-1;i++){
            int min = i;//��¼��Сֵ��λ��
            for(int j = i+1;j<len;j++){
                if(arr[j]<arr[min]){//����и�С�ģ��������Сֵ��λ��
                    min = j;
                }
            }
            //�����Сֵλ�øı��ˣ�����i�ˣ����򽻻������ǽ���Сֵ�Ӻ��滻��ǰ��
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
        ListNode pStart = new ListNode(0);//��Ӹ�����ͷ�ڵ�
        pStart = head;
        ListNode tailNode = pStart;//ָ�����ź����β���ڵ�

        while(tailNode.next!=null){
            ListNode minNode = tailNode.next;
            ListNode p = tailNode.next.next;
            //Ѱ��δ���򲿷ֵ���С�ڵ�
            while(p!=null){
                if(p.val<minNode.val){
                    minNode = p;
                }
                p = p.next;
            }
            //����ֵ
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
