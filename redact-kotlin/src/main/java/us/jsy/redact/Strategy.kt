package us.jsy.redact

import java.util.function.Function

enum class Strategy : Function<String, String> {
    /**
     * Provides the most protection, but may be at the expense of debugging.
     */
    FULL {
        override fun apply(s: String) = "***"
    },
    /**
     * This should be rarely use; maybe only for debugging
     */
    NOOP {
        override fun apply(s: String) = s
    },
    /**
     * Allow for debugging where we just need to know previous and current value is the same.
     */
    HASH {
        override fun apply(s: String): String = Integer.toHexString(s.hashCode())
    },
    /**
     * commonly use for things like credit cards, SSN or other account numbers.
     */
    LAST_4 {
        override fun apply(s: String): String {
            return if (s.length > 4) {
                "*${s.takeLast(4)}"
            } else {
                s
            }
        }
    }
}