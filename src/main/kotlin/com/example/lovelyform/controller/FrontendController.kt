package com.example.lovelyform.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping()
class FrontendControllerRestController {

}
class FrontendController {

    @GetMapping("/api/hello")
    fun hello(): Map<String, String> =
        mapOf("message" to "Hello from Spring Boot 👋")
}