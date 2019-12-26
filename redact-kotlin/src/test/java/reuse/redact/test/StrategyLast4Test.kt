package reuse.redact.test

import reuse.redact.Strategy
import kotlin.test.Test
import kotlin.test.assertEquals

class StrategyLast4Test {
    @Test
    fun longer() {
        assertEquals("*1234", Strategy.LAST_4.apply("01234"))
    }

    @Test
    fun edge() {
        assertEquals("1234", Strategy.LAST_4.apply("1234"))
    }

    @Test
    fun less() {
        assertEquals("123", Strategy.LAST_4.apply("123"))
    }
//    @Test
//    fun `null`() {
//        assertEquals(null, Strategy.LAST_4.apply(null))
//    }
}