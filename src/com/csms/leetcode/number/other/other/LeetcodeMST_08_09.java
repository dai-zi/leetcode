package com.csms.leetcode.number.other.other;

import java.util.ArrayList;
import java.util.List;

//括号
//中等
public class LeetcodeMST_08_09 {
public void dfs(List<String> list, String s, int numLeft, int numRight, int total){
        if(s.length() == total){
            //得到一个满足条件的括号串
            String t = s;
            list.add(t);
            return;
        }
        if(2 * numLeft + 1 <= total){
            //左括号的个数 + 1 <= 总括号数 - 左括号的个数,即剩下的位置必须可以容纳足够的右括号
            //可以加左括号
            dfs(list, s + "(", numLeft + 1, numRight, total);
        }
        if(numRight + 1 <= numLeft){
            //右括号的个数不能超过左括号的个数
            //可以加右括号
            dfs(list, s + ")", numLeft, numRight + 1, total);
        }
        return;
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String s = "";
        int numLeft = 0, numRight = 0;
        dfs(list, s, numLeft, numRight, n * 2);
        return list;
    }
    public static void main(String[] args) {
    }
}