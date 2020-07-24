package com.csms.leetcode.number.n1100.n1160;
//比较字符串最小字母出现频次
//简单
public class Leetcode1170 {
public int f(String s) {
	if(s==null || s.length()==0)
		return 0;
	int[] char_num = new int[26];
	char[] chars = s.toCharArray();
	//没有对字符数组进行排序后进行统计，笔者认为遍历整个数组更快，消耗空间也是常数空间
	for(char ch : chars) 
		char_num[ch-'a']++;
	for(int num : char_num)
		if(num > 0)
			return num;
	return 0;
}

public int binarySearch(int queryNum, int[] target) {
	//二分查找的稍微更改，寻找第一个比queryNum大的值，并统计其后还有多少值。
	int left = 0, right = target.length-1;
	while(left < right) {
		int mid = (left+right)/2;
		if(target[mid] > queryNum)
			right = mid;
		else
			left = mid+1;
	}
	if(target[left] <= queryNum)//注意这里，等于也是不符合条件的。
		return 0;
	else
		return target.length-left;
}
    public static void main(String[] args) {
    }
}