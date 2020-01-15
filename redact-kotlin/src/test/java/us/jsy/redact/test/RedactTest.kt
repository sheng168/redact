package us.jsy.redact.test

import us.jsy.redact.Redact
import kotlin.test.Test
import kotlin.test.assertFalse

class RedactTest {
    val secret = "secret"
    val redact = Redact(secret)

    @Test fun string() {
       val s = "$redact"
       assertFalse(s.contains(secret), "$s shouldn't contain $secret")
    }
}