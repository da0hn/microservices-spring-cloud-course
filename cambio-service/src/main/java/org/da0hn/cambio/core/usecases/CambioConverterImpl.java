package org.da0hn.cambio.core.usecases;

import lombok.AllArgsConstructor;
import org.da0hn.cambio.application.CambioRequest;
import org.da0hn.cambio.application.CambioResponse;
import org.da0hn.cambio.core.domain.CambioEntity;
import org.da0hn.cambio.core.domain.CambioNotfoundException;
import org.da0hn.cambio.data.db.JpaCambioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CambioConverterImpl implements CambioConverter {

  private static final String PORT = "local.server.port";
  private static final Logger LOGGER = LoggerFactory.getLogger(CambioConverterImpl.class);
  private final JpaCambioRepository repository;
  private final Environment environment;

  @Override public CambioResponse execute(final CambioRequest request) {
    LOGGER.info("Searching by CambioEntity using from={} & to={}", request.from(), request.to());
    final var entity = this.findCambio(request);
    LOGGER.info("CambioEntity found: {}", entity);
    return this.buildResponse(request, entity);
  }

  private CambioResponse buildResponse(final CambioRequest request, final CambioEntity entity) {
    return new CambioResponse(
      entity.getId(),
      entity.getFrom(),
      entity.getTo(),
      entity.getConversionFactor(),
      request.amount().multiply(entity.getConversionFactor()),
      this.environment.getProperty(PORT)
    );
  }

  private CambioEntity findCambio(final CambioRequest request) {
    return this.repository.findCambioEntityByFromAndTo(request.from(), request.to())
      .orElseThrow(CambioNotfoundException::new);
  }

}
