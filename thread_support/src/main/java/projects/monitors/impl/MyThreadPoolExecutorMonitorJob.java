package projects.monitors.impl;

import projects.impl.MyListeningExecutor;
import projects.impl.ThreadPoolManager;
import projects.monitors.model.MonitorInfo;
import projects.monitors.model.MonitorInfos;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class MyThreadPoolExecutorMonitorJob {

    private  volatile  boolean exit = false;

    public MyThreadPoolExecutorMonitorJob(List<Consumer<MonitorInfos>> reporters) {
        Thread monitorThread = new Thread(() -> {

            while (!exit) {
                long cycle = 1000;
                try {
                    Thread.sleep(cycle);
                    if(reporters.isEmpty()){
                        continue;
                    }
                     MonitorInfos infos = getMonitorInfos();

                    reporters.forEach(reporter -> reporter.accept(infos));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        monitorThread.setDaemon(true);
        monitorThread.start();

    }

    private MonitorInfos getMonitorInfos() {

        MonitorInfos monitors = new MonitorInfos();
        ConcurrentHashMap<String, MyListeningExecutor> executors = ThreadPoolManager.getAllThreadPools();
        int totalCurrentThreadCount  = 0;
        int totalActiveThreadCount = 0;
        int threadPoolSize =executors.size();
        List<MonitorInfo> list = new ArrayList<>(threadPoolSize);
        if(threadPoolSize>0){

            for(Map.Entry<String,MyListeningExecutor> entry: executors.entrySet()){
                MyListeningExecutor executor = entry.getValue();
                int activeCount = executor.getActiveCount();
                totalActiveThreadCount += activeCount;
                int curThreadCount = executor.getPoolSize();
                totalCurrentThreadCount += curThreadCount;
                MonitorInfo monitorInfo = new MonitorInfo();
                monitorInfo.setCorePoolSize(executor.getCorePoolSize());
                monitorInfo.setActiveThreadCount(executor.getActiveCount());
                monitorInfo.setCurrentThreadCount(executor.getPoolSize());

                list.add(monitorInfo);
            }

        }
        monitors.setTotalActiveThreadCount(totalActiveThreadCount);
        monitors.setTotalThreadCount(totalCurrentThreadCount);
        monitors.setInfoCollectors(list);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        monitors.setAliveThreadCountOnJvm(threadMXBean.getThreadCount());

        return monitors;



    }
}
