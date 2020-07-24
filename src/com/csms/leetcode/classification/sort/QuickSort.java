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
     * 分而治之，找到划分基准，并交换
     * @param nums
     * @param left
     * @param r
     * @return
     */
    public static int partation(int nums[],int left,int r){
        int pv = nums[left];//以最左边的数为基准
        int p = left;//记录基准位置
        //遍历数组，如果小于基准，则与基准交换
        for(int i = p+1;i<=r;i++){
            if(nums[i]<pv){
                p++;//基准前移
                if(p!=i){//如果是基准位置的下一个位置，则不用交换
                    swap(nums,p,i);
                }
            }
        }
        //最后，交换 划分位置 和 最左边
        swap(nums,p,left);
        return p;//返回划分位置
    }
    /**
     * 快速排序
     * @param nums
     * @param left
     * @param r
     */
    public static void quickSort(int nums[],int left,int r){
        if(left<r){//切记，一定要左边小于右边时才分部处理
            int p = partation(nums,left,r);//找到一个基准位置p
            quickSort(nums,0,p-1);//以p为中心，将数组分成两个子数组，分而治之
            quickSort(nums,p+1,r);
        }
    }
    /**
     * 快速排序
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
     * 快速排序1
     * 快速排序1（算法只交换节点的val值，平均时间复杂度O（nlogn）,不考虑递归栈空间的话空间复杂度是O（1））
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
        //用两个链表分别记录比基准小的节点 和 比基准大的节点
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
        //将前驱节点、小链表、基准节点、大链表、尾巴 连接起来
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
     * 快速排序2
     * 快速排序2（算法交换链表节点，平均时间复杂度O（nlogn）,不考虑递归栈空间的话空间复杂度是O（1））
     * @param
     * @return
     */
    public static ListNode quickSort2(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode preNode = new ListNode(0);//添加辅助的头节点
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
