package AQS;

import java.util.concurrent.CountDownLatch;

public class MyCountDownLatch {

    public static void main(String[] args) throws InterruptedException {

        int num = 3;
        final CountDownLatch countDownLatch = new CountDownLatch(num);


        for(int i = 1; i <=num; i++) {
            final int index = i;
            new Thread(() -> {

                try {
                    Thread.sleep(1000*index);
                    System.out.println("finish task:"+index);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();

        }


        try {
            countDownLatch.await();
            System.out.println("all good ");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        CountDownLatch countDownLatch1  = new CountDownLatch(num);

        for(int i = 1; i <=num; i++) {
            final int index = i;
            new Thread(() -> {

                try {
                    Thread.sleep(1000*index);
                    System.out.println("finish task:"+index);
                    countDownLatch1.countDown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();

        }
        countDownLatch1.await();
        System.out.println("end");



    }
}
