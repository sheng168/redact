package reuse.redact;

import java.util.function.Function;


public class Redact {
   protected final String pii;

   public Redact(String pii) {
      if (pii == null)
         throw new NullPointerException("input must not be null");

      this.pii = pii;
   }

   @Override
   public String toString() {
      return "<redacted " + strategy().apply(pii) + '>';
   }

   protected Function<String, String> strategy() {
      return Strategy.FULL;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Redact redact = (Redact) o;

      return pii.equals(redact.pii);
   }

   @Override
   public int hashCode() {
      return pii.hashCode();
   }
}
