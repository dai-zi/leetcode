package com.csms.leetcode.number.n1000.n1060;
//字符串的最大公因子
//简单
public class Leetcode1071 {
public String gcdOfStrings(String str1, String str2) {
        // 筛选出不存在公约数的样例
        int len1 = str1.length(), len2 = str2.length();
        boolean flag = (len1 > len2) ? isPresence(str1, str2):isPresence(str2, str1);
        if (!flag)  return "";
        
        // 存在，则直接求解
        int count = gcd(len1, len2);
        String ret = str1.substring(0, count);
        return ret;
    }
    
    private boolean isPresence(String str1, String str2) {
        // 判断是否存在公约数：即包含的元素一致，且顺序对得上
        if (str1.indexOf(str2) == -1)    return false;
        for (char c:str1.toCharArray()) {
            if (str2.indexOf(c) == -1)  return false;
        }
        return true;
    }
    
    private int gcd(int a, int b) {
        // 求两数的最大公约数
        if (a % b == 0) return b;
        else   return gcd(b, a%b);
    }
    public static void main(String[] args) {
    }
}