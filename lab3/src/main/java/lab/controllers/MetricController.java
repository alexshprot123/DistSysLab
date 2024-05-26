package lab.controllers;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lab.metrics.CounterTotalMetric;
import lab.metrics.GaugeRandomMetric;

@Path("/metric")
public class MetricController {

    @Inject
    CounterTotalMetric counterTotalMetric;

    @Inject
    GaugeRandomMetric gaugeRandomMetric;
    @GET
    @Path("/counter")
    public String counter() {
        counterTotalMetric.increment();
        Log.info("Counter metric");
        return "Counter";
    }
    @GET
    @Path("/random")
    public String random() {
        gaugeRandomMetric.random();
        Log.info("Random metric");
        return "Random";
    }
}
