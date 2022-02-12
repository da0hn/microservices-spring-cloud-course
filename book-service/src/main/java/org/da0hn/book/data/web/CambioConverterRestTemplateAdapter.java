package org.da0hn.book.data.web;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class CambioConverterRestTemplateAdapter implements CambioConverter {

  private final Environment environment;

  @Override public CambioResponse convert(final CambioRequest request) {

    final var url = this.environment.getProperty("cambio-service.url");

    final var response = new RestTemplate()
      .getForEntity(
        url + "/cambio-service?amount={amount}&from={from}&to={to}",
        CambioResponse.class,
        request.amount(),
        request.from(),
        request.to()
      );

    return response.getBody();
  }
}
