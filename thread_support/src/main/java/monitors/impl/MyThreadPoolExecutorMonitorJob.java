package monitors.impl;

import impl.MyListeningExecutor;
import impl.ThreadPoolManager;
import monitors.model.MonitorInfos;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class MyThreadPoolExecutorMonitorJob {

    private  volatile  boolean exit = false;

    public MyThreadPoolExecutorMonitorJob(List<Consumer<MonitorInfos>> reportors) {
        Thread monitorThread = new Thread(() -> {

            while (!exit) {
                long cycle = 1000;
                try {
                    Thread.sleep(cycle);
                    if(reportors.isEmpty()){
                        continue;
                    }
                     MonitorInfos infos = getMonitorInfos();

                    reportors.forEach(reportor -> reportor.accept(infos));
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
        int threadPoolSize =executors.size();


        return monitors;



    }
}
