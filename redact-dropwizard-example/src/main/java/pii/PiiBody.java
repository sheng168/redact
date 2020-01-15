package pii;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PiiBody {
    @JsonProperty
    Password password;
    @JsonProperty
    SSN ssn;
    @JsonProperty
    String name;
    @JsonProperty
    String redact;

    @Override
    public String toString() {
        return "PiiBody{" +
                "password=" + password +
                ", ssn=" + ssn +
                ", name='" + name + '\'' +
                '}';
    }
}
