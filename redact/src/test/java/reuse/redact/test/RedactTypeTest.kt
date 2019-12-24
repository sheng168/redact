package reuse.redact.test

import reuse.redact.Redact
import kotlin.test.Test
import kotlin.test.assertEquals

class RedactTypeTest {
    @Test
    fun longer() {
        assertEquals("*1234", Redact.Type.LAST_4.apply("01234"))
    }

    @Test
    fun edge() {
        assertEquals("1234", Redact.Type.LAST_4.apply("1234"))
    }

    @Test
    fun less() {
        assertEquals("123", Redact.Type.LAST_4.apply("123"))
    }
    @Test
    fun `null`() {
        assertEquals(null, Redact.Type.LAST_4.apply(null))
    }
}