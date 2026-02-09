import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/evaluate")
public class SREAgentResource {

    @Inject
    DigitalSRE agent;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SREDecision processAnalysis(AnalysisRequest request) {
        // Trigger the Agentic reasoning loop
        return agent.evaluate(request.app);
    }
}