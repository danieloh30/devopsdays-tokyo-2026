import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/orders")
public class OrderResource {

    @ConfigProperty(name = "app.cache.enabled", defaultValue = "true")
    boolean cacheEnabled;

    @GET
    public Response getOrders() {
        if (!cacheEnabled) {
            // SIMULATED GRAY FAILURE: Bypass cache, hit DB hard
            simulateDbLatency();
        }
        return Response.ok("Order list retrieved").build();
    }

    private void simulateDbLatency() {
        try { Thread.sleep(500); } catch (InterruptedException e) {}
    }
}