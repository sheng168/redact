package reuse.redact

import java.util.*
import java.util.function.Function

enum class Strategy : Function<String, String> {
    FULL {
        override fun apply(s: String): String {
            return "***"
        }
    },
    NOOP {
        override fun apply(s: String): String {
            return s
        }
    },
    HASH {
        override fun apply(s: String): String {
            return Integer.toHexString(Objects.hash(s))
        }
    },
    LAST_4 {
        override fun apply(s: String): String {
            return if (s != null && s.length > 4) {
                "*" + s.substring(s.length - 4)
            } else {
                s
            }
        }
    }
}