package reuse.redact

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


data class Record(val ssn: SSN? = null)

class RedactTests {
    private val secret = "secret"
    val redact = SSN(secret)
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