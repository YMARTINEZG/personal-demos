package us.kotlintest.rabbitpostgres

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitPostgresApplication
fun main(args: Array<String>) {
	runApplication<RabbitPostgresApplication>(*args)
}
