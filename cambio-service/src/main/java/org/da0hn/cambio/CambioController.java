package org.da0hn.cambio;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
@RequestMapping("/cambio-service")
public class CambioController {

  private final Environment environment;

  @GetMapping
  public Cambio convertMoney(
    @RequestParam("amount") final BigDecimal amount,
    @RequestParam("from") final String from,
    @RequestParam("to") final String to
  ) {
    final var port = environment.getProperty("local.server.port");
    return new Cambio(
      1L,
      from,
      to,
      BigDecimal.ONE,
      BigDecimal.ONE,
      port
    );
  }

}
