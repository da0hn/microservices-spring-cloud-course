package org.da0hn.cambio.application;

import java.math.BigDecimal;

public record CambioRequest(
  BigDecimal amount,
  String from,
  String to
) {
}
