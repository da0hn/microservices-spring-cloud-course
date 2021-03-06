package org.da0hn.book.data.web;

import org.da0hn.book.core.usecases.CambioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(
  name = "cambio-service"
)
public interface CambioProxy {

  @GetMapping("/cambio-service")
  CambioResponse convertCambio(
    @RequestParam("amount") final BigDecimal amount,
    @RequestParam("from") final String from,
    @RequestParam("to") final String to
  );


}
