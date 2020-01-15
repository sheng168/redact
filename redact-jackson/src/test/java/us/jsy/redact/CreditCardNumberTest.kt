package us.jsy.redact

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class CreditCardNumberTest {
    private val secret = "1234567890123456"
    val redact = CreditCardNumber(secret)

    @Test
    fun value() {
        assertEquals("<redacted *3456>", redact.toString())
    }

    @Test
    fun string() {
        val s = "$redact"
        assertFalse(s.contains(secret), "$s shouldn't contain $secret")
    }

    @Test
    fun json() {
        val jackson = jacksonObjectMapper()
        val s = jackson.writeValueAsString(redact)

        val copy = jackson.readValue<CreditCardNumber>(s)

        assertTrue(s.contains(secret), "$s should contain $secret")
        assertEquals(""""1234567890123456"""", s)
        assertEquals(redact, copy)
    }

}