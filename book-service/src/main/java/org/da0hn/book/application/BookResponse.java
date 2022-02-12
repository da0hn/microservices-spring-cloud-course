package org.da0hn.book.application;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BookResponse(
  Long id,
  String author,
  LocalDateTime launchDate,
  BigDecimal price,
  String title,
  String currency,
  String environment
) {
}
