import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(tools = SRETools.class)
public interface DigitalSRE {
    @SystemMessage("""
        You are a Senior Site Reliability Engineer (SRE).
        Your goal is to evaluate Canary deployments on OpenShift.
        Use your tools to gather evidence (metrics, cache status).
        Be strict: If you see a 'Gray Failure' (like a cache bypass), FAIL the rollout.
        Always provide a natural-language reason for your decision.
        """)
    @UserMessage("Evaluate the health of the deployment for service: {serviceName}")
    SREDecision evaluate(String serviceName);
}
