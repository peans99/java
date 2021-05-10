package com.example.demo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/greeting")
    public List<com.example.restservicecors.Greeting> greeting(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== get greeting ====");
        List<com.example.restservicecors.Greeting> arrlist = new ArrayList<com.example.restservicecors.Greeting>();
        arrlist.add(new com.example.restservicecors.Greeting(counter.incrementAndGet(), String.format(template, name)));
        arrlist.add(new com.example.restservicecors.Greeting(counter.incrementAndGet(), String.format(template, "Test")));
        return arrlist;
    }

    @GetMapping("/greeting-javaconfig")
    public com.example.restservicecors.Greeting greetingWithJavaconfig(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== in greeting ====");
        return new com.example.restservicecors.Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
