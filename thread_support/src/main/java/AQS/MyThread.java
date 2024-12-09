package AQS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;

public class MyThread implements Runnable{

    private CyclicBarrier barrier ;
    private ExecutorService exec;
    public MyThread(CyclicBarrier barrier, ExecutorService exec, int N){
        this.barrier = barrier ;
        this.exec = exec;
        for (int i = 0; i < N-1; ++i){
            exec.execute(new WriteTask(barrier));
        }
    }

    @Override
    public void run(){
        while (!Thread.interrupted()){
            try {
                barrier.await();
            }catch (InterruptedException e){

            }catch (BrokenBarrierException e){
                throw new RuntimeException(e);
            }
        }
    }


}
