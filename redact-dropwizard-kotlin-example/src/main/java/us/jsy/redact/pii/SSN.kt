package us.jsy.redact.pii

import us.jsy.redact.RedactJackson
import us.jsy.redact.Strategy
import java.util.function.Function

class SSN(pii: String?) : RedactJackson(pii) {
    override fun strategy(): Function<String, String> {
        return Strategy.LAST_4
    }
}