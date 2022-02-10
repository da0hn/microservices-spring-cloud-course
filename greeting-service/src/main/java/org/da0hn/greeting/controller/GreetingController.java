package org.da0hn.greeting.controller;

import org.da0hn.greeting.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

  private static final String TEMPLATE = "Hello, %s";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping
  public Greeting greeting(
    @RequestParam(value = "name", defaultValue = "World") String name
  ) {
    return new Greeting(
      String.format(TEMPLATE, name),
      counter.incrementAndGet()
    );
  }


}
