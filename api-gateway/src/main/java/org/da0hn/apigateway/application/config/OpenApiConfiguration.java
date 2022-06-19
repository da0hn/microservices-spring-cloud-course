package org.da0hn.apigateway.application.config;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OpenApiConfiguration {

  @Bean
  @Lazy(false)
  public List<GroupedOpenApi> apis(final SwaggerUiConfigParameters parameters, final RouteDefinitionLocator locator) {
    final var definitions = locator.getRouteDefinitions()
      .collectList()
      .block();

    definitions.stream().filter(definition -> definition.getId().matches(".*-service"))
      .forEach(definition -> {
        final String name = definition.getId();
        parameters.addGroup(name);
        GroupedOpenApi.builder()
          .pathsToMatch("/" + name + "/")
          .group(name)
          .build();
      });
    return new ArrayList<>();
  }

}
