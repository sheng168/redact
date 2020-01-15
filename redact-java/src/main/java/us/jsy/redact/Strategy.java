package us.jsy.redact;

import java.util.Objects;
import java.util.function.Function;

public enum Strategy implements Function<String, String> {
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
         return Integer.toHexString(Objects.hash(s));
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
