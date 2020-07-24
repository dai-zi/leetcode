package com.csms.leetcode.number.n400.n400;
//数字转换为十六进制数
//简单
public class Leetcode405 {
    public String toHex(int num) {
        if(num==0)
            return "0";
        String hex="0123456789abcdef",ans="";
        while(num!=0&&ans.length()<8){
            ans=hex.charAt(num&0xf)+ans;
            num>>=4;
        }
        return ans;
    }
    public static void main(String[] args) {
    }
}