package com.csms.leetcode.classification.other;

public class ByteDance {
        static int[] a = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        public static void main(String[] args) {
            getResult(1);//������1��ʼ
        }

        /**
         *
         * @param index
         *             ��1-7
         */
        public static void getResult(int index) {
            if (index == 4) {//��������4
                //index++;
            }
            if (index >= 5) {//��ʱ˵��1-7���ֶ���ȡ��,����𰸼���
                for (int i = 1; i < a.length; i++) {
                    System.out.print(a[i]);
                }
                System.out.println();
                return;
            }
            //i--->λ��
            for (int i = 3; i < 8; i++) {
                if ((i + index + 1) <= 10 && a[i] == 0 && a[i + index + 1] == 0) {
                    a[i] = a[i + index + 1] = index;
                    getResult(index + 1);
                    //------------------------------
                    //ִ�е���һ��˵����ʱ������index���ʺ���λ��i,���ظ�ֵ
                    a[i] = a[i + index + 1] = 0;
                }
            }
        }


}
