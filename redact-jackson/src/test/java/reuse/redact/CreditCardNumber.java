package reuse.redact;

import java.util.function.Function;

public class CreditCardNumber extends RedactJackson {
    public CreditCardNumber(String pii) {
        super(pii);
    }

    @Override
    protected Function<String, String> strategy() {
        return Strategy.LAST_4;
    }
}
