package org.da0hn.cambio.core.domain;

import java.io.Serial;

public class CambioNotfoundException extends RuntimeException {

  @Serial private static final long serialVersionUID = -4476156200779386882L;

  public CambioNotfoundException() {
    super("Cambio not found.");
  }

  public CambioNotfoundException(final String message) {
    super(message);
  }
}
