package monitors.model;

import java.util.*;

/**
 * 一个服务的运行可能涉及到多个线程池，核心的非核心的，或者根据不同业务进行划分
 */
public class MonitorInfos {

    private List<MonitorInfo> infoCollectors = new ArrayList<>();

    private int threadPoolCount;
    private int totalActiveThreadCount;
    private int totalThreadCount;
    private int aliveThreadCountOnJvm;

    public List<MonitorInfo> getInfoCollectors() {
        return infoCollectors;
    }

    public void setInfoCollectors(List<MonitorInfo> infoCollectors) {
        this.infoCollectors = infoCollectors;
    }

    public int getAliveThreadCountOnJvm() {
        return aliveThreadCountOnJvm;
    }

    public void setAliveThreadCountOnJvm(int aliveThreadCountOnJvm) {
        this.aliveThreadCountOnJvm = aliveThreadCountOnJvm;
    }

    public int getTotalActiveThreadCount() {
        return totalActiveThreadCount;
    }

    public void setTotalActiveThreadCount(int totalActiveThreadCount) {
        this.totalActiveThreadCount = totalActiveThreadCount;
    }

    public int getTotalThreadCount() {
        return totalThreadCount;
    }

    public void setTotalThreadCount(int totalThreadCount) {
        this.totalThreadCount = totalThreadCount;
    }

    public int getThreadPoolCount() {
        return threadPoolCount;
    }

    public void setThreadPoolCount(int threadPoolCount) {
        this.threadPoolCount = threadPoolCount;
    }
}
