package org.da0hn.cambio.application;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Cambio endpoint")
public class CambioController {

  private final CambioConverter cambioConverter;

  @GetMapping
  @Operation(summary = "Return converted amount based on `from` and `to` request parameters")
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
