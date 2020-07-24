package com.csms.leetcode.number.n1200.n1220;
//哲学家进餐
//中等
public class Leetcode1226 {
//volatile Leetcode1226[] forks = new Leetcode1226[]{
//        new Semaphore(1)
//        , new Semaphore(1)
//        , new Semaphore(1)
//        , new Semaphore(1)
//        , new Semaphore(1)
//    };
//
//    public DiningPhilosophers() {
//
//    }
//
//    // call the run() method of any runnable to execute its code
//    public void wantsToEat(int philosopher,
//                           Runnable pickLeftFork,
//                           Runnable pickRightFork,
//                           Runnable eat,
//                           Runnable putLeftFork,
//                           Runnable putRightFork) throws InterruptedException {
//
//        // philosopher 表示哲学家的 index 号
//
//        int leftForkNo = philosopher;
//        int rightForkNo = (philosopher + 1) % 5;
//
//        if (philosopher % 2 == 0) {
//            forks[leftForkNo].acquire();
//            forks[rightForkNo].acquire();
//        } else {
//            forks[rightForkNo].acquire();
//            forks[leftForkNo].acquire();
//        }
//
//        pickLeftFork.run();
//        pickRightFork.run();
//
//        eat.run();
//
//        putLeftFork.run();
//        putRightFork.run();
//
//        forks[leftForkNo].release();
//        forks[rightForkNo].release();
//    }

    public static void main(String[] args) {
    }
}