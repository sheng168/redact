package us.jsy.redact

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length

class Saying {
    @get:JsonProperty
    var id: Long = 0
        private set

    @get:JsonProperty
    var content: @Length(max = 3) String? = null
        private set

    constructor() {
        // Jackson deserialization
    }

    constructor(id: Long, content: String?) {
        this.id = id
        this.content = content
    }

}