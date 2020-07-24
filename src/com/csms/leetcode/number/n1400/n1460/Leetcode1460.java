package com.csms.leetcode.number.n1400.n1460;
//通过翻转子数组使两个数组相等
public class Leetcode1460{
public boolean canBeEqual(int[] target, int[] arr) {
        int length = target.length;
        int match=0;
        for(int i = 0;i<length;i++)
          for(int j =0;j<length;j++)
          {
              if(target[i]==arr[j])
              {
                  match++;
                  break;
              }
          }
        return match==length?true:false;
    }
    public static void main(String[] args) {
    }
}