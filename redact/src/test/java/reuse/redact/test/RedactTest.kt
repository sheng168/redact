package reuse.redact.test

import reuse.redact.Redact
import kotlin.test.Test
import kotlin.test.assertFalse

class RedactTest {
    class FullRedact(s: String): Redact(s) {
        override fun toString(): String {
            return Type.FULL.apply(pii);
        }
    }

    val secret = "secret"
    val redact = FullRedact(secret)

    @Test fun string() {
       val s = "$redact"
       assertFalse(s.contains(secret), "$s shouldn't contain $secret")
    }
}