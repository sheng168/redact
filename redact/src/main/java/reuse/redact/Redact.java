package reuse.redact;

public final class Redact {
   private final String pii;

   public String toString() {
      return "<redacted " + Integer.toHexString(this.pii.hashCode()) + '>';
   }

   public final String getPii() {
      return this.pii;
   }

   public Redact(String pii) {
      super();
      this.pii = pii;
   }
}
