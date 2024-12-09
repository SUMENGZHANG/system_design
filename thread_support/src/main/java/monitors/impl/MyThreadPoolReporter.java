package monitors.impl;

import monitors.model.MonitorInfos;

import java.util.function.Consumer;

public class MyThreadPoolReporter implements Consumer<MonitorInfos> {

    @Override
    public void accept(MonitorInfos monitorInfos) {

    }

    @Override
    public Consumer<MonitorInfos> andThen(Consumer<? super MonitorInfos> after) {
        return Consumer.super.andThen(after);
    }
}
