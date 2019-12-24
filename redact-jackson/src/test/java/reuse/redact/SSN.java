package reuse.redact;

public class SSN extends RedactJackson {
    public SSN(String pii) {
        super(pii);
    }

    SSN fromString(String s) {
        return new SSN(s);
    }
}
