package org.da0hn.cambio.application;

import lombok.AllArgsConstructor;
import org.da0hn.cambio.core.usecases.CambioConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
@RequestMapping("/cambio-service")
public class CambioController {

  private final CambioConverter cambioConverter;

  @GetMapping
  public CambioResponse convertMoney(
    @RequestParam("amount") final BigDecimal amount,
    @RequestParam("from") final String from,
    @RequestParam("to") final String to
  ) {
    return this.cambioConverter.execute(new CambioRequest(
      amount,
      from,
      to
    ));
  }

}
