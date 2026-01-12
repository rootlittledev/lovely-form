package com.example.lovelyform.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class FrontendController {

    @GetMapping("/hello")
    fun hello(): Map<String, String> =
        mapOf("message" to "Hello from Spring Boot 👋")
}