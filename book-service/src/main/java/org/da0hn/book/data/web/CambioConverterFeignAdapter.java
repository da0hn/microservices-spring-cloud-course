package org.da0hn.book.data.web;

import lombok.AllArgsConstructor;
import org.da0hn.book.core.usecases.CambioConverter;
import org.da0hn.book.core.usecases.CambioRequest;
import org.da0hn.book.core.usecases.CambioResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@AllArgsConstructor
public class CambioConverterFeignAdapter implements CambioConverter {

  private final CambioProxy cambioProxy;

  @Override public CambioResponse convert(final CambioRequest request) {
    return this.cambioProxy.convertCambio(request.amount(), request.from(), request.to());
  }
}
