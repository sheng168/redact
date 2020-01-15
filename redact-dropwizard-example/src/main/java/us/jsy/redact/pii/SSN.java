package us.jsy.redact.pii;

import us.jsy.redact.RedactJackson;
import us.jsy.redact.Strategy;

import java.util.function.Function;

public class SSN extends RedactJackson {
    public SSN(String pii) {
        super(pii);
    }

    @Override
    protected Function<String, String> strategy() {
        return Strategy.LAST_4;
    }
}
