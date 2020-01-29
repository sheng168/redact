package us.jsy.redact

import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import javax.validation.constraints.NotEmpty

class HelloWorldConfiguration : Configuration() {
    @get:JsonProperty
    @set:JsonProperty
    var template: @NotEmpty String? = "Hello, %s!"

    @get:JsonProperty
    @set:JsonProperty
    var defaultName: @NotEmpty String? = "Stranger"

}