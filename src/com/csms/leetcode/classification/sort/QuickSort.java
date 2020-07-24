package com.csms.leetcode.classification.sort;

import com.csms.leetcode.common.ListNode;

import java.util.List;

public class QuickSort {
    public static void swap(int nums[],int i,int j){
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }

    public static void sortByList(ListNode head){
        quickSort(head);
        head = head.next;
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static void sortByList2(ListNode head){
        quickSort2(head);
        head = head.next;
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * �ֶ���֮���ҵ����ֻ�׼��������
     * @param nums
     * @param left
     * @param r
     * @return
     */
    public static int partation(int nums[],int left,int r){
        int pv = nums[left];//������ߵ���Ϊ��׼
        int p = left;//��¼��׼λ��
        //�������飬���С�ڻ�׼�������׼����
        for(int i = p+1;i<=r;i++){
            if(nums[i]<pv){
                p++;//��׼ǰ��
                if(p!=i){//����ǻ�׼λ�õ���һ��λ�ã����ý���
                    swap(nums,p,i);
                }
            }
        }
        //��󣬽��� ����λ�� �� �����
        swap(nums,p,left);
        return p;//���ػ���λ��
    }
    /**
     * ��������
     * @param nums
     * @param left
     * @param r
     */
    public static void quickSort(int nums[],int left,int r){
        if(left<r){//�мǣ�һ��Ҫ���С���ұ�ʱ�ŷֲ�����
            int p = partation(nums,left,r);//�ҵ�һ����׼λ��p
            quickSort(nums,0,p-1);//��pΪ���ģ�������ֳ����������飬�ֶ���֮
            quickSort(nums,p+1,r);
        }
    }
    /**
     * ��������
     * @param nums
     */
    public static void sort(int nums[]){
        int len = nums.length;
        quickSort(nums,0,len-1);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
    public static void swap(ListNode i,ListNode j){
        int temp = i.val;
        i.val = j.val;
        j.val = temp;
    }
    private static ListNode partation(ListNode head, ListNode tail) {
        int ppv = head.val;
        ListNode p = head;
        for(ListNode i = p.next;i!=tail;i = i.next){
            if(i.val<ppv){
                p = p.next;
                if(i!=p){
                    swap(i,p);
                }
            }
        }
        swap(p,head);
        return p;
    }

    public static void quickSort(ListNode head,ListNode tail){
        if(head!=tail&&head.next!=tail){
            ListNode p = partation(head,tail);
            quickSort(head,p);
            quickSort(p.next,tail);
        }
    }

    /**
     * ��������1
     * ��������1���㷨ֻ�����ڵ��valֵ��ƽ��ʱ�临�Ӷ�O��nlogn��,�����ǵݹ�ջ�ռ�Ļ��ռ临�Ӷ���O��1����
     * @param head
     * @return
     */
    public static ListNode quickSort(ListNode head){
        if(head == null || head.next == null) return head;
        quickSort(head,null);
        return head;
    }

    public static ListNode partation2(ListNode preNode,ListNode head,ListNode tail){
        int ppv = head.val;
        //����������ֱ��¼�Ȼ�׼С�Ľڵ� �� �Ȼ�׼��Ľڵ�
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode s = small,b = big;

        for(ListNode i = head.next;i!=tail;i=i.next){
            if(i.val<ppv){
                s.next = i;
                s = s.next;
            }else{
                b.next = i;
                b = b.next;
            }
        }
        //��ǰ���ڵ㡢С������׼�ڵ㡢������β�� ��������
        b.next = tail;
        s.next = head;
        head.next = big.next;
        preNode.next = small.next;

        return head;

    }

    public static void quickSort2(ListNode preNode,ListNode head,ListNode tail){
        if(head!=tail && head.next!=tail ){
            ListNode p = partation2(preNode,head,tail);
            quickSort2(preNode,preNode.next,p);
            quickSort2(p,p.next,tail);
        }
    }

    /**
     * ��������2
     * ��������2���㷨��������ڵ㣬ƽ��ʱ�临�Ӷ�O��nlogn��,�����ǵݹ�ջ�ռ�Ļ��ռ临�Ӷ���O��1����
     * @param
     * @return
     */
    public static ListNode quickSort2(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode preNode = new ListNode(0);//��Ӹ�����ͷ�ڵ�
        preNode.next = head;
        quickSort2(preNode,head,null);
        return preNode.next;
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
        sortByList2(head);
        sort(arr);
    }
}
