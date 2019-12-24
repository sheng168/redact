package reuse.redact;

import com.fasterxml.jackson.annotation.JsonCreator;

public class SSN extends RedactJackson {
//    @JsonCreator
    public SSN(String pii) {
        super(pii);
        System.out.println("SSN " + pii);
    }

//    SSN fromString(String s) {
//        return new SSN(s);
//    }
}
