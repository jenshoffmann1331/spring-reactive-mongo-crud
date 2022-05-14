package com.me.reactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringReactiveMongoCrudApplication

fun main(args: Array<String>) {
    runApplication<SpringReactiveMongoCrudApplication>(*args)
}
