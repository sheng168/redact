package us.jsy.redact

import java.util.function.Function

/**
 * Helps prevent PII(Personally identifiable information) from being printed or logged by overriding toString().
 */
open class Redact(pii: String) {
    @JvmField
    protected val pii: String = pii

    /**
     * Final to prevent subclasses from accidentally undoing our work
     */
    final override fun toString(): String {
        return "<redacted ${strategy().apply(pii)}>"
    }

    /**
     * Extension point to allow subclasses to redaction strategy. Default to Strategy.FULL
     */
    protected open fun strategy(): Function<String, String> {
        return Strategy.FULL
    }

    // equals and hashCode implementation allow wrapper to be use transparently in place of String
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val redact = other as Redact
        return pii == redact.pii
    }

    override fun hashCode(): Int {
        return pii.hashCode()
    }

}