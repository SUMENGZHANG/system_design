package monitors.model;

/**
 * 用来收集每个线程池的关键信息
 */
public class MonitorInfo {

    private String threadPoolName;
    private int corePoolSize;
    private int maxPoolSize;
    private int activeThreadCount;
    private int currentQueueLength;
    private int queueLength;
    private int alarmQueueLength;

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

    public int getCurrentQueueLength() {
        return currentQueueLength;
    }

    public void setCurrentQueueLength(int currentQueueLength) {
        this.currentQueueLength = currentQueueLength;
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
