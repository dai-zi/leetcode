package com.csms.leetcode.number.n1000.n1020;

import java.util.ArrayList;
import java.util.List;

//驼峰式匹配
//中等
public class Leetcode1023 {
public static List<Boolean> camelMatch(String[] queries, String pattern) {
    	List<Boolean> res = new ArrayList<>();
    	
    	for(int i=0; i<queries.length; i++){
    		String quer = queries[i];
    		int pattIndex = 0;
    		boolean flag = true;
    		for(int j=0; j<quer.length(); j++){
    			char ch = quer.charAt(j);
    			if(pattIndex<pattern.length() && ch == pattern.charAt(pattIndex)){
    				pattIndex++;
    			}else{
    				if(!(ch>='a' && ch<='z')){
    					res.add(false);
    					flag = false;
    					break;
    				}
    			}
    		}
    		if(flag && pattIndex != pattern.length()){
    			res.add(false);
    		}else if(flag && pattIndex == pattern.length()){
    			res.add(true);
    		}
    	}
    	
    	return res;
    }

    public static void main(String[] args) {
    }
}