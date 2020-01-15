package pii;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("pii")
public class PiiResource {
    private static final Logger logger = LoggerFactory.getLogger(PiiResource.class);

    public PiiResource() {
        logger.info("ctor");
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Password getMemberInfo(@PathParam("id") Password password) {
        logger.info("password: {}", password);
        return password;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public PiiBody put(PiiBody piiBody) {
        logger.info("piiBody: {}", piiBody);
        piiBody.redact = piiBody.toString();
        return piiBody;
    }
}
