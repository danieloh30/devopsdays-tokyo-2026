import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SRETools {

    @Tool("Fetch the HTTP latency (P95) for a specific service over the last 5 minutes")
    public double getP95Latency(String serviceName) {
        // Real implementation would call the Prometheus REST API
        System.out.println("Agent is fetching P95 metrics for: " + serviceName);
        return 0.550; // Returns 550ms for the demo
    }

    @Tool("Check if the cache-hit-rate has dropped significantly for a service")
    public String getCacheStatus(String serviceName) {
        return "Cache Hit Rate: 2% (Warning: Down from 90%)";
    }
}
