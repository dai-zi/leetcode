package com.csms.leetcode.number.other.other;

import java.util.HashMap;
import java.util.Map;

//单词频率
//中等
public class LeetcodeMST_16_02 {
Map<String,Integer> recMap = new HashMap<>();
    public LeetcodeMST_16_02(String[] book) {
    	for(int i=0;i<book.length;i++) {
    		if(!recMap.containsKey(book[i])) {
    			recMap.put(book[i],1);
    		}else {
    			recMap.put(book[i], recMap.get(book[i])+1);
    		}
    	}
    }
    
    public int get(String word) {
        if(recMap.containsKey(word)) {
    		return recMap.get(word);
    	}
    	return 0;
    }

    public static void main(String[] args) {
    }
}