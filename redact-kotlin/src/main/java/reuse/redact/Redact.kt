package reuse.redact

import java.util.function.Function

open class Redact(pii: String) {
    @JvmField
    protected val pii: String

    override fun toString(): String {
        return "<redacted " + redact().apply(pii) + '>'
    }

    protected open fun redact(): Function<String, String> {
        return Strategy.FULL
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val redact = o as Redact
        return pii == redact.pii
    }

    override fun hashCode(): Int {
        return pii.hashCode()
    }

    init {
        if (pii == null) throw NullPointerException("input must not be null")
        this.pii = pii
    }
}