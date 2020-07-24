package com.csms.leetcode.number.n300.n340;
//反转字符串中的元音字母
//简单
public class Leetcode345 {
    public String reverseVowels(String s) {
        if(s.length()<2) return s;
        char[]chars = s.toCharArray();
        int i= 0; int j = chars.length -1 ;
        while(i<j){
            if(chars[i]=='a'||chars[i]=='e'||chars[i]=='o'||chars[i]=='i'||chars[i]=='u'||chars[i]=='A'||chars[i]=='E'||chars[i]=='O'||chars[i]=='I'||chars[i]=='U'){
                if(chars[j]=='a'||chars[j]=='e'||chars[j]=='o'||chars[j]=='i'||chars[j]=='u'||chars[j]=='A'||chars[j]=='E'||chars[j]=='O'||chars[j]=='I'||chars[j]=='U'){
                    if(chars[i]!=chars[j]){
                        char temp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = temp;
                    }
                    ++i;
                    --j;
                }else{
                    --j;
                }
            }else{
                ++i;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
    }
}