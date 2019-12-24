package reuse.redact;


import com.fasterxml.jackson.annotation.JsonValue;

public abstract class RedactJackson extends Redact {
    public RedactJackson(String pii) {
        super(pii);
    }

    @JsonValue
    String toJson() {
        return pii;
    }

   /*
   RedactJson fromString(String s) {
      return new RedactJson(s);
   }
    */
}
