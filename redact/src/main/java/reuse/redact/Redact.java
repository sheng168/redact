package reuse.redact;

import java.util.Objects;
import java.util.function.Function;

public abstract class Redact {
   protected final String pii;

   public Redact(String pii) {
      this.pii = pii;
   }

   @Override
   public String toString() {
      return "<redacted " + redact().apply(pii) + '>';
   }

   protected Function<String, String> redact() {
      return Type.FULL;
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
      return Objects.hash(pii);
   }

   public enum Type implements Function<String, String> {
      FULL {
         public String apply(String s) {
            return "***";
         }
      },
      NOOP {
         public String apply(String s) {
            return s;
         }
      },
      HASH {
         public String apply(String s) {
            return Integer.toHexString(s.hashCode());
         }
      },
      LAST_4 {
         public String apply(String s) {
            if (s != null && s.length() > 4) {
               return "*" + s.substring(s.length() - 4);
            } else {
               return s;
            }
         }
      };
   }
}
