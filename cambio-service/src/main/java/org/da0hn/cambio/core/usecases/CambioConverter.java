package org.da0hn.cambio.core.usecases;

import org.da0hn.cambio.application.CambioRequest;
import org.da0hn.cambio.application.CambioResponse;

public interface CambioConverter {
  CambioResponse execute(CambioRequest request);
}
