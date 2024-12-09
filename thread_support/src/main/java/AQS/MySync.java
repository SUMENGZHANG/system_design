package AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MySync extends AbstractQueuedSynchronizer {


    public MySync(int limit) {
        setState(limit);
    }

    final int getLimit(){
        return getState();
    }


    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }
}
