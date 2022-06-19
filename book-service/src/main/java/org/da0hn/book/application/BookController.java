package org.da0hn.book.application;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.da0hn.book.core.usecases.BookQuery;
import org.da0hn.book.core.usecases.BookResponse;
import org.da0hn.book.core.usecases.GetBookById;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-service")
@AllArgsConstructor
@Tag(name = "Book endpoint")
public class BookController {

  private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
  private final GetBookById getBookById;

  @Operation(summary = "Find a specific book by your ID and price specified by your currency")
  @GetMapping("/{idBook}")
  public BookResponse getBookById(
    @PathVariable final Long idBook,
    @RequestParam final String currency
  ) {
    LOGGER.info("GET /book-service/{} idBook={} & currency={}", idBook, idBook, currency);
    final var response = this.getBookById.execute(new BookQuery(idBook, currency));
    LOGGER.info("Response {}", response);
    return response;
  }

}
