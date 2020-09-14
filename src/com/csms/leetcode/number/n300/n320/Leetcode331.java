package com.csms.leetcode.number.n300.n320;
//验证二叉树的前序序列化
//中等
public class Leetcode331 {
    //diedai
    public boolean isValidSerialization(String preorder) {
        // number of available slots
        int slots = 1;

        for(String node : preorder.split(",")) {
            // one node takes one slot
            --slots;

            // no more slots available
            if (slots < 0) return false;

            // non-empty node creates two children slots
            if (!node.equals("#")) slots += 2;
        }

        // all slots should be used up
        return slots == 0;
    }
    //yi bian guo
    public boolean isValidSerialization1(String preorder) {
        // number of available slots
        int slots = 1;

        int n = preorder.length();
        for(int i = 0; i < n; ++i) {
            if (preorder.charAt(i) == ',') {
                // one node takes one slot
                --slots;

                // no more slots available
                if (slots < 0) return false;

                // non-empty node creates two children slots
                if (preorder.charAt(i - 1) != '#') slots += 2;
            }
        }

        // the last node
        slots = (preorder.charAt(n - 1) == '#') ? slots - 1 : slots + 1;
        // all slots should be used up
        return slots == 0;
    }
    public static void main(String[] args) {
    }
}