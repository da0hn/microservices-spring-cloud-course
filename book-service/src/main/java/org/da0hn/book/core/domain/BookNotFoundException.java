package org.da0hn.book.core.domain;

import java.io.Serial;

public class BookNotFoundException extends RuntimeException {
  @Serial private static final long serialVersionUID = 4990357376380207509L;

  public BookNotFoundException() {
    super("Book not found.");
  }

  public BookNotFoundException(final String message) {
    super(message);
  }
}
