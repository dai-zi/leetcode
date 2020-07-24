package com.csms.leetcode.number.n1400.n1440;

import java.util.ArrayList;
import java.util.List;

//用栈操作构建数组
//简单
public class Leetcode1441 {
public List<String> buildArray(int[] target, int n) {
        int l = target.length;  
        List<String> sl = new ArrayList<String>();
        int j = 0;
        for(int i = 1; i<=n;i++){
            if(i < target[j] ){  // 1.不在target中
                sl.add("Push");
                sl.add("Pop");
            }else{    //2.在target中
                sl.add("Push");
                j++;
                if(j == l){ //3. 终止条件
                    break;
                }
            }
        }
        return sl;
    }

    public static void main(String[] args) {
    }
}