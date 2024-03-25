package com.springboot.errorhandling.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.errorhandling.exception.BadRequestException;
import com.springboot.errorhandling.exception.GlobalExceptionHandler;

@RestController
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @GetMapping("/")
    public String retResponse(@RequestParam(required = false) String name) {

        logger.info("Call retResponse");

        if (name == null) {
            throw new BadRequestException("Please provide your name");
        }
        return String.format("Hey %s, you got a response", name);
    }

    // curl http://localhost:8080?name=abhi -w "\n"
    // curl http://localhost:8080 -w "\n"
}
