package impl;

import com.google.common.util.concurrent.AbstractListeningExecutorService;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyListeningExecutor extends AbstractListeningExecutorService {

    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return List.of();
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void execute(Runnable command) {

    }
}
