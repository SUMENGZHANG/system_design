package AQS;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyCyclicBarrier {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {


        int N = 4;
        CyclicBarrier barrier  = new CyclicBarrier(N);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new MyThread(barrier,exec,N));
        exec.shutdown();





    }

    public static void run( List<Runnable> threads) throws InterruptedException, BrokenBarrierException {

        for (Runnable thread : threads) {
            new Thread(thread).start();

        }
    }
}
