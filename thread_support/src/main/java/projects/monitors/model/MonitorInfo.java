package projects.monitors.model;

/**
 * 用来收集每个线程池的关键信息
 */
public class MonitorInfo {

    private String threadPoolName;
    private int corePoolSize;
    private int maxPoolSize;
    // 正在处理任务的线程数
    private int activeThreadCount;
    // 当前线程数
    private int currentThreadCount;
    private int queueLength;
    private int alarmQueueLength;

    public int getCurrentThreadCount() {
        return currentThreadCount;
    }

    public void setCurrentThreadCount(int currentThreadCount) {
        this.currentThreadCount = currentThreadCount;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }
    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public String getThreadPoolName() {
        return threadPoolName;
    }

    public void setThreadPoolName(String threadPoolName) {
        this.threadPoolName = threadPoolName;
    }

    public int getActiveThreadCount() {
        return activeThreadCount;
    }

    public void setActiveThreadCount(int activeThreadCount) {
        this.activeThreadCount = activeThreadCount;
    }


    public int getQueueLength() {
        return queueLength;
    }

    public void setQueueLength(int queueLength) {
        this.queueLength = queueLength;
    }

    public int getAlarmQueueLength() {
        return alarmQueueLength;
    }

    public void setAlarmQueueLength(int alarmQueueLength) {
        this.alarmQueueLength = alarmQueueLength;
    }
}
