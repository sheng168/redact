package reuse.redact.test

import reuse.redact.Strategy
import kotlin.test.Test
import kotlin.test.assertEquals

class StrategyTest {
    val s = Strategy.NOOP

    @Test
    fun less() {
        assertEquals("123", s.apply("123"))
    }
    @Test
    fun `null`() {
        assertEquals(null, s.apply(null))
    }
}