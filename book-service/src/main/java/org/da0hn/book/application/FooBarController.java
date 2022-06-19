package org.da0hn.book.application;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/book-service")
@AllArgsConstructor
@Tag(name = "Endpoints to test Resilience4j")
public class FooBarController {

  private static final Logger LOGGER = LoggerFactory.getLogger(FooBarController.class);

  @GetMapping("foo-bar")
  @Bulkhead(name = "default")
  @CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
  @RateLimiter(name = "default")
  @Operation(summary = "Get `foo-bar` string for test `CircuitBreaker`, `RateLimiter` and `Bulkhead`")
  public String fooBar() {
    LOGGER.info("Request to foo-bar is received");
    final var response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
    return response.getBody();
  }

  @GetMapping("foo-baz")
  @RateLimiter(name = "default")
  @Operation(summary = "Get `foo-baz` string for test `RateLimiter`")
  public String fooBaz() {
    LOGGER.info("Request to foo-baz is received");
    return "foo-baz";
  }

  @GetMapping("foo-qux")
  @Bulkhead(name = "default")
  @Operation(summary = "Get `foo-qux` string for test `Bulkhead`")
  public String fooQux() {
    LOGGER.info("Request to foo-baz is received");
    return "foo-qux";
  }

  public String fallbackMethod(final Exception exception) {
    return "fallback method foo-bar";
  }

}
