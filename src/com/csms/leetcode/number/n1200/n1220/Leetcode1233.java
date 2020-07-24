package com.csms.leetcode.number.n1200.n1220;

import java.util.*;

//删除子文件夹
//中等
public class Leetcode1233 {
public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder,(s1, s2)->s1.length()-s2.length());
		Set<String> set= new TreeSet<>((s1, s2)->{
			if(s1.contains(s2+"/"))
				return 0;
			return s1.compareTo(s2);
		});
		Collections.addAll(set,folder);
		return new ArrayList<>(set);
    }

    public static void main(String[] args) {
    }
}