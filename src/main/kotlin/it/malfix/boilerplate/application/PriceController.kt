package it.malfix.boilerplate.application

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PriceController {
    @GetMapping("/autocomplete")
    fun autocomplete(@RequestParam("q") query: String) {

    }
}