package impl;

import com.google.common.util.concurrent.AbstractListeningExecutorService;

import java.util.concurrent.*;



/**
 * Just add a thread name for debug in future
 */
public class MyExecutor extends ThreadPoolExecutor {

    private final String threadPoolName;

    public MyExecutor(
            String threadPoolName,
            int corePoolSize,
            int maximumPoolSize,
            long keepAliveTime,
            TimeUnit unit,
            BlockingQueue<Runnable> workQueue,
            RejectedExecutionHandler rejectedExecutionHandler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,rejectedExecutionHandler);
        this.threadPoolName = threadPoolName;
    }
    public String getExecutorName(){
        return threadPoolName;
    }
}
