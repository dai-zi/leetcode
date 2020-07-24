package com.csms.leetcode.number.n1100.n1100;
//H2O生成
//中等
public class Leetcode1117 {
//private ReentrantLock lock = new ReentrantLock();
//    private Condition hCondition = lock.newCondition();
//    private Condition oCondition = lock.newCondition();
//    //前2位代表氢元素的个数,第3位代表氧元素的个数
//    private int h2o = 0;
//
//    public H2O() {}
//
//    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
//        lock.lock();
//        //00(0个H元素) 01(1个H元素) 11(2个H元素)
//        //((h2o & 3) == 3)表示H元素已经到了2个
//        while((h2o & 3) == 3) {
//            hCondition.await();
//        }
//        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
//        releaseHydrogen.run();
//        //==0代表没有1个氢元素,否则一定会有1个氢元素
//        h2o += ((h2o & 3) == 0) ? 1 : 2;
//        //水分子已经生成
//        if(h2o == 7){
//            h2o = 0;
//        }
//        //唤醒一个氧线程
//        oCondition.signal();
//        //如果((h2o & 3) == 3)表示氢线程不需要再唤醒了
//        if((h2o & 3) != 3){
//            hCondition.signal();
//        }
//        lock.unlock();
//    }
//
//    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
//        lock.lock();
//        //((h2o & 4) == 4)表示O元素已经到了1个
//        while((h2o & 4)==4){
//            oCondition.await();
//        }
//        // releaseOxygen.run() outputs "O". Do not change or remove this line.
//		releaseOxygen.run();
//        h2o += 4;
//        //水分子已经生成
//        if(h2o == 7){
//            h2o = 0;
//        }
//        //因为只需要1个氧元素,所以这里只需要唤醒氢线程就可以了
//        hCondition.signal();
//        lock.unlock();
//    }

    public static void main(String[] args) {
    }
}