package com.csms.leetcode.classification.other;

public class ByteDance {
        static int[] a = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        public static void main(String[] args) {
            getResult(1);//从数字1开始
        }

        /**
         *
         * @param index
         *             数1-7
         */
        public static void getResult(int index) {
            if (index == 4) {//跳过数字4
                //index++;
            }
            if (index >= 5) {//此时说明1-7数字都被取完,输出答案即可
                for (int i = 1; i < a.length; i++) {
                    System.out.print(a[i]);
                }
                System.out.println();
                return;
            }
            //i--->位数
            for (int i = 3; i < 8; i++) {
                if ((i + index + 1) <= 10 && a[i] == 0 && a[i + index + 1] == 0) {
                    a[i] = a[i + index + 1] = index;
                    getResult(index + 1);
                    //------------------------------
                    //执行到这一步说明此时的数字index不适合于位置i,撤回赋值
                    a[i] = a[i + index + 1] = 0;
                }
            }
        }


}
