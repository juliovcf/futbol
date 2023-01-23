package com.torneo.futbol.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmptyController {

    @GetMapping("/")
    public void emptyMethod() {
    }
}
