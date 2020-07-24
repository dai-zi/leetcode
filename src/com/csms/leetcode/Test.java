package com.csms.leetcode;

import com.csms.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public void test() {
        new Solution().new ListNode();
    }

    public static void judge(int a){


    }

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        //System.out.println(judge(5));
        int i = 0;
        while (true){
            res.add("abcdefg");
//            for(int j = 0; j < 10000; j++){
//                int[] a = new int[1000];
//            }
            ListNode tmp = new ListNode(i);
            //System.gc();
            if(i% 10000 == 0) {
                System.out.println(i++);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
