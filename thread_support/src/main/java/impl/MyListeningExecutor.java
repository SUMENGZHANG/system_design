package impl;

import com.google.common.util.concurrent.AbstractListeningExecutorService;

import java.util.List;
import java.util.concurrent.*;

public class MyListeningExecutor extends AbstractListeningExecutorService {



    private int maxQueueSize;
    private String executorName;
    private int alarmQueueValue;
    private final ThreadPoolExecutor executor;


    public MyListeningExecutor( String executorName,
                                int corePoolSize,
                               int maxPoolSize,
                               int keepAliveTime,
                               TimeUnit unit,
                               BlockingQueue<Runnable> workQueue,
                               ThreadFactory threadFactory,
                               RejectedExecutionHandler handler,
                               int alarmQueueValue
                              ) {
        this.executor = new MyExecutor(
                executorName,
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler
        );
        this.alarmQueueValue = alarmQueueValue;
        this.executorName = executorName;
        this.maxQueueSize = ((ResizableCapacityLinkedBlockingQueue) workQueue).getCapacity();
    }


    /**
     * 当前正在执行任务的线程数
     * @return
     */
    public int getActiveCount(){
        return executor.getActiveCount();
    }
    public int getPoolSize(){
        return executor.getPoolSize();
    }

    public int getQueueSize(){
        return executor.getQueue().size();
    }
    public int getCorePoolSize(){
        return executor.getCorePoolSize();
    }

    public void setCorePoolSize(int corePoolSize){
        executor.setCorePoolSize(corePoolSize);
    }

    public void setMaximumPoolSize(int maximumPoolSize){
        executor.setMaximumPoolSize(maximumPoolSize);
    }


    @Override
    public void shutdown() {
        executor.shutdown();

    }

    @Override
    public List<Runnable> shutdownNow() {
        return List.of();
    }

    @Override
    public boolean isShutdown() {
        return executor.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return executor.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void execute(Runnable command) {
        executor.execute(command);
    }

}
