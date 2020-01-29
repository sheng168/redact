package us.jsy.redact

import io.dropwizard.Application
import io.dropwizard.setup.Environment
import us.jsy.redact.pii.PiiResource

class HelloWorldApplication : Application<HelloWorldConfiguration>() {
    override fun getName(): String {
        return "hello-world"
    }

    //
    //    @Override
    //    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
    //        // nothing to do yet
    //    }
    override fun run(configuration: HelloWorldConfiguration,
                     environment: Environment) {
        val resource = HelloWorldResource(
                configuration.template,
                configuration.defaultName
        )
        val healthCheck = TemplateHealthCheck(configuration.template)
        environment.healthChecks().register("template", healthCheck)
        environment.jersey().register(resource)
        environment.jersey().register(PiiResource())
    }

    companion object {
        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            HelloWorldApplication().run(*args)
        }
    }
}