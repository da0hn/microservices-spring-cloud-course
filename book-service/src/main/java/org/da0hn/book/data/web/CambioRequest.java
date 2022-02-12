package org.da0hn.book.data.web;

import java.math.BigDecimal;

public record CambioRequest(
  BigDecimal amount,
  String from,
  String to
) {
}
