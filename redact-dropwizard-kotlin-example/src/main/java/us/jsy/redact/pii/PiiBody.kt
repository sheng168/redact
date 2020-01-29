package us.jsy.redact.pii

import com.fasterxml.jackson.annotation.JsonProperty

class PiiBody {
    @JsonProperty
    var password: Password? = null

    @JsonProperty
    var ssn: SSN? = null

    @JsonProperty
    var name: String? = null

    @JsonProperty
    var redact: String? = null
    override fun toString(): String {
        return "PiiBody{" +
                "password=" + password +
                ", ssn=" + ssn +
                ", name='" + name + '\'' +
                '}'
    }
}