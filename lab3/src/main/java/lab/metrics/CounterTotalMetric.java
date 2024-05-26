package lab.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CounterTotalMetric {
    @Inject
    private MeterRegistry registry;
    private Counter counter;

    public CounterTotalMetric(MeterRegistry registry) {
        counter = registry.counter("total_counter");
    }

    public void increment() {
        counter.increment();
    }
}
