package us.jsy.redact.pii

import org.slf4j.LoggerFactory
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("pii")
class PiiResource {
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getMemberInfo(@PathParam("id") password: Password): Password {
        logger.info("password: {}", password)
        return password
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    fun put(piiBody: PiiBody): PiiBody {
        logger.info("piiBody: {}", piiBody)
        piiBody.redact = piiBody.toString()
        return piiBody
    }

    companion object {
        private val logger = LoggerFactory.getLogger(PiiResource::class.java)
    }

    init {
        logger.info("ctor")
    }
}