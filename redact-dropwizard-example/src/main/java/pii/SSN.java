package pii;

import reuse.redact.RedactJackson;
import reuse.redact.Strategy;

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
