package com.trip.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author deng
 * @date 2018/12/22
 */
@RestController
public class TestController {
    @GetMapping
    public String test() {
        return "test";
    }
}
