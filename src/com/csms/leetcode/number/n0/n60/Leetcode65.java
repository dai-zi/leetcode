package com.csms.leetcode.number.n0.n60;
//有效数字
//困难
public class Leetcode65 {
    public int make(char c) {
        switch(c) {
            case ' ': return 0;
            case '+':
            case '-': return 1;
            case '.': return 3;
            case 'e': return 4;
            default:
                if(c >= 48 && c <= 57) return 2;
        }
        return -1;
    }

    public boolean isNumber(String s) {
        int state = 0;
        int finals = 0b101101000;
        int[][] transfer = new int[][]{{ 0, 1, 6, 2,-1},
                {-1,-1, 6, 2,-1},
                {-1,-1, 3,-1,-1},
                { 8,-1, 3,-1, 4},
                {-1, 7, 5,-1,-1},
                { 8,-1, 5,-1,-1},
                { 8,-1, 6, 3, 4},
                {-1,-1, 5,-1,-1},
                { 8,-1,-1,-1,-1}};
        char[] ss = s.toCharArray();
        for(int i=0; i < ss.length; ++i) {
            int id = make(ss[i]);
            if (id < 0) return false;
            state = transfer[state][id];
            if (state < 0) return false;
        }
        return (finals & (1 << state)) > 0;
    }
    //
    public boolean isNumber1(String s) {
        if(s==null||s.length()==0) return false;
        boolean numSeen=false;
        boolean dotSeen=false;
        boolean eSeen=false;
        char arr[]=s.trim().toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]>='0'&&arr[i]<='9'){
                numSeen=true;
            }else if(arr[i]=='.'){
                if(dotSeen||eSeen){
                    return false;
                }
                dotSeen=true;
            }else if(arr[i]=='E'||arr[i]=='e'){
                if(eSeen||!numSeen){
                    return false;
                }
                eSeen=true;
                numSeen=false;
            }else if(arr[i]=='+'||arr[i]=='-'){
                if(i!=0&&arr[i-1]!='e'&&arr[i-1]!='E'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return numSeen;
    }

    public static void main(String[] args) {
    }
}