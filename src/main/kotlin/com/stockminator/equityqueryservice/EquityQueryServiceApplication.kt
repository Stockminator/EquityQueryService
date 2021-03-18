package com.stockminator.equityqueryservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class EquityQueryServiceApplication

fun main(args: Array<String>) {
	runApplication<EquityQueryServiceApplication>(*args)
}
