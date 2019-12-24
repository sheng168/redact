package maven.kotlin.beta

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import reuse.redact.RedactJson
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Password(pii: String): RedactJson(pii) {
    override fun toString(): String {
        return Type.HASH.apply(pii)
    }
}

data class Record(val ssn: Password? = null)

class RedactTests {
    private val secret = "secret"
    val redact = Password(secret)
    val record = Record(redact)

    @Test
    fun value() {
        assertEquals(secret, redact.pii)
    }

    @Test
    fun string() {
        val s = "$redact"
        assertFalse(s.contains(secret), "$s shouldn't contain $secret")
//        assertEquals("<redacted>", s)
    }

    @Test
    fun json() {
        val jackson = jacksonObjectMapper()
        val s = jackson.writeValueAsString(record)

        val copy = jackson.readValue<Record>(s)

        assertTrue(s.contains(secret), "$s should contain $secret")
        assertEquals("""{"ssn":"secret"}""", s)
        assertEquals(record, copy)
    }

}