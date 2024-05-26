package lab.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.jboss.logging.Logger;

@Path("/log")
public class LogController {
    private static final Logger LOG = Logger.getLogger(LogController.class);
    @GET
    public String logMessage() {
        LOG.info("My log message");
        return "Counter";
    }
}
