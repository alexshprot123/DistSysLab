package lab.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class GaugeRandomMetric {
    @Inject
    private MeterRegistry registry;
    private AtomicInteger randomGauge;

    public GaugeRandomMetric(MeterRegistry registry) {
        randomGauge = registry.gauge("gauge_random_value", new AtomicInteger(0));
    }

    public void random() {
        int randomNum = new Random().nextInt(10);
        Log.info("RandomNum: " + randomNum);
        randomGauge.set(randomNum);
    }
}
