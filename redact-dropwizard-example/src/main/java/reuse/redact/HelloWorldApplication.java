package reuse.redact;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import pii.PiiResource;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
//        long product = 1_099_551_473_989L;
//
//        for (long f1 = 2; f1 < Math.sqrt(product); f1++) {
//            long f2 = product / f1;
//            if (f2 * f1 == product) {
//                System.out.println(f1 + " * " + f2);
//                break;
//            }
//        }

        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }
//
//    @Override
//    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
//        // nothing to do yet
//    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().register(new PiiResource());
    }

}