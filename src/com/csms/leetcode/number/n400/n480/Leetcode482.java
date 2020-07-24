package com.csms.leetcode.number.n400.n480;
//密钥格式化
//简单
public class Leetcode482 {
    public String licenseKeyFormatting(String S, int K) {
        char[] chars = S.toCharArray();
        char[] result = new char[chars.length+S.length()/K];
        int length = 0;
        int i = chars.length - 1, j = result.length - 1;
        for (; i >= 0;) {
            if (chars[i] == '-') {
                i--;
                continue;
            }
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] -32);
            }
            if (length != K) {
                result[j] = chars[i];
                length++;
                if (i == 0) {
                    j--;
                    break;
                }else{
                    j--;
                    i--;
                }
            }else{
                length = 1;
                result[j] = '-';
                result[j - 1] = chars[i];
                j -= 2;
                i--;

            }
        }

        return new String(result, j+1, result.length - j-1);
    }
    public static void main(String[] args) {
    }
}