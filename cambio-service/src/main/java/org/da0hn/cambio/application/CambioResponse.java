package org.da0hn.cambio.application;

import java.math.BigDecimal;

public record CambioResponse(
  Long id,
  String from,
  String to,
  BigDecimal conversionFactor,
  BigDecimal convertedValue,
  String environment
) {
}
