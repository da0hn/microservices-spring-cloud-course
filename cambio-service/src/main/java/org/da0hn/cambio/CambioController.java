package org.da0hn.cambio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cambio-service")
public class CambioController {

  @GetMapping
  public Cambio convertMoney(
    @RequestParam("amount") final BigDecimal amount,
    @RequestParam("from") final String from,
    @RequestParam("to") final String to
  ) {
    return new Cambio(
      1L,
      from,
      to,
      BigDecimal.ONE,
      BigDecimal.ONE,
      "PORT 8000"
    );
  }

}
