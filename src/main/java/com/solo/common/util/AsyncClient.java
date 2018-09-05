package com.solo.common.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: GaoJean
 * @ClassName: AsyncClient
 * @Description: TODO
 * @date: 2018/9/5
 */
public class AsyncClient {
    private static ExecutorService executor = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws InterruptedException {

        boolean r = task2();

        if (r) {
            task3();
        }

        System.out.println("------------main end-----------");
    }

    static boolean task2() throws InterruptedException {

//        ExecutorDemo e = new ExecutorDemo();

        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("2");
                try {
                    System.out.println("3");
                    Thread.sleep(10000);//方便观察结果
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("4");
                int sum = 0;
                for (int i = 0; i < 1000; i++) {

                    sum += i;
                }

                System.out.println(sum);
            }
        });

        System.out.println("------------task2 end-----------");

        return true;
    }


    static void task3() throws InterruptedException {
        int j = 0;
        while (true) {
            if (j++ > 10000) {
                break;
            }
        }

        System.out.println("------------task3 end-----------");
    }
}
