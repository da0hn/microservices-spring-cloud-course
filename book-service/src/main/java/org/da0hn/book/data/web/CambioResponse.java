package org.da0hn.book.data.web;

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
