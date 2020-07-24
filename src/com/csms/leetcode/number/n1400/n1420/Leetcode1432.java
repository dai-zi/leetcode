package com.csms.leetcode.number.n1400.n1420;
//改变一个整数能得到的最大差值
//中等
public class Leetcode1432 {
public int maxDiff(int num) {
        char nine = Integer.toString(9).charAt(0);
        char zero = Integer.toString(0).charAt(0);
        char one = Integer.toString(1).charAt(0);
        boolean p = true;// 指示第一个数->默认取大
        String nStr1 = Integer.toString(num);
        String nStr2 = Integer.toString(num);

        // 操作数1
        for (int i = 0; i < nStr1.length(); ++i) {
            if (i == 0) {// 首位
                if (nStr1.charAt(i) == one) {
                    p = false;
                } else if (nStr1.charAt(i) != nine) {
                    nStr1 = nStr1.replace(nStr1.charAt(i), nine);
                    break;
                }
            } else {// 非首位
                if ((p && nStr1.charAt(i) != nine) || (!p && nStr1.charAt(i) != zero && nStr1.charAt(i) != one)) {
                    if (p) {
                        nStr1 = nStr1.replace(nStr1.charAt(i), nine);
                    } else {
                        nStr1 = nStr1.replace(nStr1.charAt(i), zero);
                    }
                    break;
                }
            }
        }

        // 操作数2
        if (p) {// 与第一个操作数反向
            nStr2 = nStr2.replace(nStr2.charAt(0), one);
        } else {
            nStr2 = nStr2.replace(nStr2.charAt(0), nine);
        }

        return p ? (Integer.parseInt(nStr1) - Integer.parseInt(nStr2)) : (Integer.parseInt(nStr2) - Integer.parseInt(nStr1));
    }

    public static void main(String[] args) {
    }
}