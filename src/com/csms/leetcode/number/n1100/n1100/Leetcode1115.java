package com.csms.leetcode.number.n1100.n1100;
//交替打印FooBar
//中等
public class Leetcode1115 {
//private ReentrantLock lock = new ReentrantLock();
//    private Condition fooCondition = lock.newCondition();
//    private Condition barCondition = lock.newCondition();
//    private int count = 1;
//    private int n;
//
//    public FooBar(int n) {
//        this.n = n;
//    }
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//            lock.lock();
//            if(count != 1) {
//                fooCondition.await();
//            }
//            // printFoo.run() outputs "foo". Do not change or remove this line.
//        	printFoo.run();
//            barCondition.signal();
//            count=2;
//            lock.unlock();
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//            lock.lock();
//            if(count != 2) {
//                barCondition.await();
//            }
//            // printBar.run() outputs "bar". Do not change or remove this line.
//        	printBar.run();
//            fooCondition.signal();
//            count=1;
//            lock.unlock();
//        }
//    }

    public static void main(String[] args) {
    }
}