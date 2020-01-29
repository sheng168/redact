package us.jsy.redact

import com.codahale.metrics.annotation.Timed
import org.slf4j.LoggerFactory
import java.util.*
import java.util.concurrent.atomic.AtomicLong
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
class HelloWorldResource(private val template: String?, private val defaultName: String?) {
    private val counter: AtomicLong

    @GET
    @Timed
    fun sayHello(@QueryParam("name") name: Optional<String?>): Saying {
        logger.debug("name: {}", name)
        val value = String.format(template!!, name.orElse(defaultName))
        logger.info("say: {}", value)
        return Saying(counter.incrementAndGet(), value)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(HelloWorldResource::class.java)
    }

    init {
        counter = AtomicLong()
    }
}