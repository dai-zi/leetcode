package com.csms.leetcode.classification.bignum;

public class Multiply {
    public String multiply(String a, String b) {
        char[] aCs = a.toCharArray();
        char[] bCs = b.toCharArray();
        int[] re = new int[aCs.length + bCs.length];
        char[] res = new char[re.length];
        for (int i = 0; i < bCs.length; i++) {
            for (int j = 0; j < aCs.length; j++) {
                re[i + j + 1] += (bCs[i] - '0') * (aCs[j] - '0');
            }
        }

        for (int i = re.length - 1; i >= 0; i--) {
            res[i] = (char) ('0' + (re[i] % 10));
            if (i > 0) {
                re[i - 1] += re[i] / 10;
            }
        }
        int i = 0;
        while (i < res.length - 1 && res[i] == '0') {
            res[i++] = 0;
        }
        return String.valueOf(res).trim();
    }
}
