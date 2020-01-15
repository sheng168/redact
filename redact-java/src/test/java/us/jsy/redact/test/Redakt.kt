package us.jsy.redact.test

import us.jsy.redact.Strategy
import java.util.function.Function


open class Redakt(protected val pii: String) {
    override fun toString(): String {
        return "<redacted " + redact().apply(pii) + '>'
    }

    protected open fun redact(): Function<String?, String> {
        return Strategy.FULL
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (this.javaClass != other?.javaClass) return false

        other as Redakt

        if (pii != other.pii) return false

        return true
    }

    override fun hashCode(): Int {
        return pii.hashCode()
    }

//    override fun equals(o: Any?): Boolean {
//        if (this === o) return true
//        if (o == null || javaClass != o.javaClass) return false
//        val redact = o as Redact
//        return pii == redact.pii
//    }
//
//    override fun hashCode(): Int {
//        return Objects.hash(pii)
//    }

}
