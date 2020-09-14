package com.csms.leetcode.number.n400.n420;
//扁平化多级双向链表
//中等
public class Leetcode430 {

    //di gui
    private Node prev = null;
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private void dfs(Node head) {
        if (head == null) return;
        Node next = head.next;
        if (prev != null) {
            prev.next = head;
            head.prev = prev;
        }
        prev = head;
        dfs(head.child);
        head.child = null;
        dfs(next);
    }


    //die dai

    public static void main(String[] args) {
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}