package reuse.redact.test

import reuse.redact.Strategy
import kotlin.test.Test
import kotlin.test.assertNotEquals

class StrategyHashTest {
    val s = Strategy.HASH

    @Test
    fun `should not be NOOP`() {
        assertNotEquals("123", s.apply("123"))
    }

    @Test
    fun `different input should produce different output(mostly)`() {
        assertNotEquals(s.apply("1"), s.apply("2"))
    }
}