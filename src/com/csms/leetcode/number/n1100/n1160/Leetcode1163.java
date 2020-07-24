package com.csms.leetcode.number.n1100.n1160;
//按字典序排在最后的子串
//困难
public class Leetcode1163 {
    public String lastSubstring(String s) {

        char[] str = s.toCharArray();
        int index = str.length-1;
        int max = 0;

        for(int i=str.length-1;i>=0;i--){
            if(str[i]-'a'>max){
                index = i;
                max = str[i]-'a';
            }else if(str[i]-'a'==max){
                if(i-1>=0&&str[i]==str[i-1]) continue;//非常关键！！！
                int temp = index;
                index = i;
                max = str[i]-'a';
                for(int j=i,k=temp;j<str.length&&k<str.length;j++,k++){
                    if(str[k]-'a'==str[j]-'a') continue;
                    if(str[k]-'a'>str[j]-'a'){
                        index = temp;
                        max = str[index]-'a';
                        break;
                    }else if(str[k]-'a'<str[j]-'a'){
                        break;
                    }
                }
            }
        }

        return s.substring(index);
    }
    public static void main(String[] args) {
    }
}