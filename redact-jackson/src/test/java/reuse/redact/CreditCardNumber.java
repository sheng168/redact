package reuse.redact;

import java.util.function.Function;

public class CreditCardNumber extends RedactJackson {
    public CreditCardNumber(String pii) {
        super(pii);
        System.out.println("CreditCardNumber " + pii);
    }

    @Override
    protected Function<String, String> redact() {
        return Type.LAST_4;
    }
}