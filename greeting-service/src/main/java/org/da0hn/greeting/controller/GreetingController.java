package org.da0hn.greeting.controller;

import org.da0hn.greeting.configuration.GreetingConfiguration;
import org.da0hn.greeting.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

  private static final String TEMPLATE = "%s, %s";
  private final AtomicLong counter = new AtomicLong();

  private final GreetingConfiguration greetingConfiguration;

  @Autowired
  public GreetingController(GreetingConfiguration greetingConfiguration) {
    this.greetingConfiguration = greetingConfiguration;
  }

  @GetMapping
  public Greeting greeting(
    @RequestParam(value = "name", defaultValue = "") String name
  ) {

    if(name.isEmpty()) {
      name = this.greetingConfiguration.getDefaultValue();
    }

    return new Greeting(
      String.format(
        TEMPLATE,
        this.greetingConfiguration.getGreeting(),
        name
      ),
      counter.incrementAndGet()
    );
  }


}
