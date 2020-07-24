package com.csms.leetcode.classification.linkedlist;

import com.csms.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {public ListNode mergeKLists(ListNode[] lists) {
    ListNode head = null;
    ListNode tail = null;
    if(lists == null || lists.length == 0){
        return head;
    }
    PriorityQueue<ListNode> priorityQueue = new PriorityQueue(new IdComparator());
    for(int i = 0; i < lists.length; i++){
        if(lists[i] != null) {
            priorityQueue.add(lists[i]);
        }
    }

    while(priorityQueue.size() > 0){
        ListNode tmp = priorityQueue.remove();
        if(tmp.next != null){
            priorityQueue.add(tmp.next);
        }
        tmp.next = null;
        if(head == null){
            tail = tmp;
            head = tail;
        }else{
            tail.next = tmp;
            tail = tail.next;
        }
    }
    return head;
}
}
class IdComparator implements Comparator<ListNode> {

    @Override
    public int compare(ListNode c1, ListNode c2) {
        return (int)(c1.val - c2.val);
    }
}