package org.da0hn.book.core.usecases;

import lombok.AllArgsConstructor;
import org.da0hn.book.core.domain.BookEntity;
import org.da0hn.book.core.domain.BookNotFoundException;
import org.da0hn.book.data.db.JpaBookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@AllArgsConstructor
public class GetBookById {

  private static final String PORT = "local.server.port";
  private static final String DEFAULT_CURRENCY = "USD";
  private static final Logger LOGGER = LoggerFactory.getLogger(GetBookById.class);
  private final Environment environment;
  private final JpaBookRepository repository;
  @Resource(name = "cambioConverterFeignAdapter")
  private final CambioConverter cambioConverter;

  public BookResponse execute(final BookQuery query) {
    final var book = this.fetchBook(query);
    final var port = this.environment.getProperty(PORT);

    final var price = book.getPrice();

    final var cambioResponse = this.cambioConverter.convert(new CambioRequest(
      price,
      DEFAULT_CURRENCY,
      query.currency()
    ));

    LOGGER.info("Book Port: {} - Cambio Port: {}", port, cambioResponse.environment());

    return new BookResponse(
      book.getId(),
      book.getAuthor(),
      book.getLaunchDate(),
      cambioResponse.convertedValue(),
      book.getTitle(),
      query.currency(),
      String.format(
        "book-service port: %s - cambio-service port: %s",
        port,
        cambioResponse.environment()
      )
    );
  }


  private BookEntity fetchBook(final BookQuery query) {
    return this.repository.findById(query.idBook())
      .orElseThrow(BookNotFoundException::new);
  }


}
