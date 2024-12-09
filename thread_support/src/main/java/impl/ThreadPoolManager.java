package impl;

import monitors.impl.MyThreadPoolReporter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolManager {

    // 用来存储单例的线程池
    private static final ConcurrentHashMap<String,MyListeningExecutor> threadPoolMap = new ConcurrentHashMap<>();

    // 线程同步锁
    private static final Object lock = new Object();

    private static final String DEFAULT_THREAD_POOL_NAME = "default_thread_pool";

    private static final ThreadPoolConfig defaultThreadPoolConfig = new ThreadPoolConfig(DEFAULT_THREAD_POOL_NAME);

    private static final Map<String, ThreadPoolConfig> threadPoolConfigMap = new ConcurrentHashMap<>();

    private static final Map<String, RejectedExecutionHandler> rejectHandlerMap = new ConcurrentHashMap<>();

    // default discard policy
    public static final RejectedExecutionHandler DEFAULT_HANDLER = new ThreadPoolExecutor.DiscardPolicy();

    static{
        init();
    }
    public static void init(){
        // init reject policies
        rejectPoliciesRegister();
        registerReporter(new MyThreadPoolReporter());
    }

    private static void registerReporter(MyThreadPoolReporter myThreadPoolReporter) {



    }

    private static void rejectPoliciesRegister() {
        rejectHandlerMap.put("AbortPolicy", new ThreadPoolExecutor.AbortPolicy());
        rejectHandlerMap.put("CallerRunsPolicy", new ThreadPoolExecutor.CallerRunsPolicy());
        rejectHandlerMap.put("DiscardPolicy", new ThreadPoolExecutor.DiscardPolicy());
        rejectHandlerMap.put("DiscardOldestPolicy", new ThreadPoolExecutor.DiscardOldestPolicy());
    }


    public static ConcurrentHashMap<String,MyListeningExecutor> getAllThreadPools(){
        return threadPoolMap;
    }

}
