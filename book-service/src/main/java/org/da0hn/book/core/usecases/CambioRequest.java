package org.da0hn.book.core.usecases;

import java.math.BigDecimal;

public record CambioRequest(
  BigDecimal amount,
  String from,
  String to
) {
}
