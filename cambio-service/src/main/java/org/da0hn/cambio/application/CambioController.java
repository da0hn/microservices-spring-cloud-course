package org.da0hn.cambio.application;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.da0hn.cambio.core.usecases.CambioConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  private static final Logger LOGGER = LoggerFactory.getLogger(CambioController.class);
  private final CambioConverter cambioConverter;

  @GetMapping
  @Operation(summary = "Return converted amount based on `from` and `to` request parameters")
  public CambioResponse convertMoney(
    @RequestParam("amount") final BigDecimal amount,
    @RequestParam("from") final String from,
    @RequestParam("to") final String to
  ) {
    LOGGER.info("GET /cambio-service?amount={}&from={}&to={}", amount, from, to);
    final var response = this.cambioConverter.execute(new CambioRequest(
      amount,
      from,
      to
    ));
    LOGGER.info("Response: {}", response);
    return response;
  }

}
