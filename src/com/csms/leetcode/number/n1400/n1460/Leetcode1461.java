package com.csms.leetcode.number.n1400.n1460;

import java.util.HashSet;

//简查一个字符串是否包含所有长度为K的二进制子串
//简单
public class Leetcode1461 {
	public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet();
        for(int i = 0; i <= s.length() -k;i++){
            set.add(s.substring(i,i+k));
        }
        return set.size() == (int)Math.pow(2,k);
          
    }

    public static void main(String[] args) {
    }
}