package AQS;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

class WriteTask implements Runnable{
    private static int count = 0;
    private final int id = count++;
    private CyclicBarrier barrier ;
    private static Random random = new Random(47);
    public WriteTask(CyclicBarrier cyclicBarrier) {
        this.barrier = cyclicBarrier;
    }

    @Override
    public void run() {

        while (!Thread.interrupted()){
            System.out.println(this+" 开始写入数据...");
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(5000));
                System.out.println(this+" 写入数据完毕，等待其他线程写入完毕"+" "+System.currentTimeMillis());
                barrier.await();
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(this + "is interrupted!");
            }catch(BrokenBarrierException e){
                throw new RuntimeException(e);
            }
            System.out.println("所有任务写入完毕，继续处理其他任务... "+System.currentTimeMillis());
        }

    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"-"+id;
    }
}

