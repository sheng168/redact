package reuse.redact;

import java.util.function.Function;

public abstract class Redact {
   private final String pii;

   public abstract String toString();
//   {
//      return "<redacted " + Integer.toHexString(this.pii.hashCode()) + '>';
//   }

   public final String getPii() {
      return this.pii;
   }

   public Redact(String pii) {
      super();
      this.pii = pii;
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
            if (s.length() > 4) {
               return "*" + s.substring(s.length() - 4);
            } else {
               return s;
            }
         }
      };
   }
}
