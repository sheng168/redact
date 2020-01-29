package us.jsy.redact

import com.codahale.metrics.health.HealthCheck

class TemplateHealthCheck(private val template: String?) : HealthCheck() {
    @Throws(Exception::class)
    override fun check(): Result {
        val saying = String.format(template!!, "TEST")
        return if (!saying.contains("TEST")) {
            Result.unhealthy("template doesn't include a name")
        } else Result.healthy()
    }

}