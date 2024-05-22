package lab.rest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Path("/rabbitmq")
public class RestRabbitmq {
    @Channel("quote-requests")
    Emitter<String> emitter;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void sendMessage(String message) {
        emitter.send(message);
    }
}
