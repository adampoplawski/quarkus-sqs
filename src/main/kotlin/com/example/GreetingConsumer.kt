package com.example

import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.reactive.messaging.Incoming

@ApplicationScoped
class GreetingConsumer {

    @Incoming("greetings")
    fun hello(greeting: String) {
        println(greeting)
    }
}