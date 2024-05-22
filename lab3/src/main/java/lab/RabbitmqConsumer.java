package lab;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class RabbitmqConsumer {
    @Incoming("requests")
    public void process(String msg) {
        Log.info("RabbitMQ message: " + msg);
    }
}
