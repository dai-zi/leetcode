package com.csms.leetcode.number.n400.n460;
//验证IP地址
//中等
public class Leetcode468 {
    public String validIPAddress(String IP) {
        String[] IP4Arr = IP.split("\\.",-1);
        if(IP4Arr.length == 4){
            return isIP4Arr(IP4Arr);
        }

        String[] IP6Arr = IP.split(":",-1);
        if(IP6Arr.length == 8){
            return isIP6Arr(IP6Arr);
        }

        return "Neither";
    }

    public String isIP4Arr(String[] IP4Arr){
        for(String ip : IP4Arr){
            if(ip.length() > 3 || ip.length() <= 0){
                return "Neither";
            }
            for(int i = 0 ;i < ip.length();++i){
                if(!Character.isDigit(ip.charAt(i))){
                    return "Neither";
                }
            }
            int num = Integer.parseInt(ip);
            if(num > 255 || String.valueOf(num).length() != ip.length()){
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String isIP6Arr(String[] IP6Arr){
        for(String ip : IP6Arr){
            if(ip.length() > 4 || ip.length() <= 0){
                return "Neither";
            }
            for(int i = 0 ;i < ip.length();++i){
                char c = ip.charAt(i);
                if(!Character.isDigit(c) && !( 'a' <= c && c <= 'f') && !('A' <= c && c <= 'F')){
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }
    public static void main(String[] args) {
    }
}