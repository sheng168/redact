package us.jsy.redact;

import com.fasterxml.jackson.annotation.JsonValue;
import us.jsy.redact.Redact;

public abstract class RedactJackson extends Redact {
    public RedactJackson(String pii) {
        super(pii);
    }

    @JsonValue
    String toJson() { // actually use by Jackson
        return pii;
    }
}
