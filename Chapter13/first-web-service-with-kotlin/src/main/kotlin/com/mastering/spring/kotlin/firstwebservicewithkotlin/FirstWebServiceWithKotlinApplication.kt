package com.mastering.spring.kotlin.firstwebservicewithkotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class FirstWebServiceWithKotlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(FirstWebServiceWithKotlinApplication::class.java, *args)
}
