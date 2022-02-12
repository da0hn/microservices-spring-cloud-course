package org.da0hn.book;

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
