package be.challenge

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

@SpringBootApplication
@PropertySources(
    PropertySource(value = ["classpath:application.properties"])
)
@ComponentScan
class Application

fun main() {
    runApplication<Application>()
}