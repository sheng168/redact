package reuse.redact

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RedactTests {
    class FullRedact(s: String): Redact(s) {
        override fun toString(): String {
            return Type.FULL.apply(pii);
        }
    }

    val secret = "secret"
    val redact = FullRedact(secret)

    @Test fun value() {
        assertEquals(secret, redact.pii)
    }

    @Test fun string() {
       val s = "$redact"
       assertFalse(s.contains(secret), "$s shouldn't contain $secret")
    }

    @Test fun json() {
       val s = redact.pii
       assertTrue(s.contains(secret), "$s should contain $secret")
    }


}