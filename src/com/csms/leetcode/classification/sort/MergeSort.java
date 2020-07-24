package com.csms.leetcode.classification.sort;

import com.csms.leetcode.common.ListNode;

import java.util.List;

public class MergeSort {
    public static void merge(int nums[],int temp[],int left,int mid,int r){
        //����һ������
        for(int i = left;i<=r;i++){
            temp[i] = nums[i];
        }
        //��¼���Ҳ��ֵ�����
        int pa = left,pb = mid+1;
        int index = left;//�ϲ������������

        while(pa<=mid&&pb<=r){
            if(temp[pa]<=temp[pb]){//��һ����С���Ϳ�����һ���ֵ�������
                nums[index++] = temp[pa++];
            }else{
                nums[index++] = temp[pb++];
            }
        }
        //����û�п�����Ĳ��֣�ֱ�Ӹ�ֵ��������
        while(pa<=mid){
            nums[index++] = temp[pa++];
        }
        while(pb<=r){
            nums[index++] = temp[pb++];
        }


    }
    /**
     * �鲢����
     * @param nums
     * @param temp
     * @param left
     * @param r
     */
    public static void mergeSort(int nums[],int temp[],int left,int r){
        if(left<r){//���С���ұ�ʱ���ֶ���֮
            int mid = (left+r)/2;
            mergeSort(nums,temp,0,mid);
            mergeSort(nums,temp,mid+1,r);
            //�ϲ�
            merge(nums,temp,left,mid,r);
        }
    }
    /**
     * �鲢����
     * @param nums
     */
    public static void sort(int nums[]){
        int len = nums.length;
        int temp[] = new int[len];
        mergeSort(nums,temp,0,len-1);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * �ϲ���������Ϊ��������
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode pNode = new ListNode(0);
        ListNode p = pNode;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if(l1!=null){
            p.next = l1;
        }
        if(l2!=null){
            p.next = l2;
        }
        return pNode.next;
    }

    /**
     * �鲢����
     * �鲢�����㷨��������ڵ㣬ʱ�临�Ӷ�O��nlogn��,�����ǵݹ�ջ�ռ�Ļ��ռ临�Ӷ���O��1����
     * @param head
     */
    public static ListNode mergeSort(ListNode head){
        if(head == null || head.next == null) return head;
        //������ָ�뷨��������ֳ�������
        ListNode slow = head,fast = head;
        while(fast.next!=null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;//��벿��
        slow.next = null;//�Ͽ�
        //�ݹ鴦������������
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(fast);
        //�ϲ�����������Ϊ��������
        return merge(l1,l2);
    }
    public static void sortByList(ListNode head){
        mergeSort(head);
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
        sort(arr);
        //insertBinarySort(arr);
    }
}
