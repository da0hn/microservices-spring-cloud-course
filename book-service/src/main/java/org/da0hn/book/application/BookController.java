package org.da0hn.book.application;

import lombok.AllArgsConstructor;
import org.da0hn.book.core.usecases.BookQuery;
import org.da0hn.book.core.usecases.BookResponse;
import org.da0hn.book.core.usecases.GetBookById;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-service")
@AllArgsConstructor
public class BookController {

  private final GetBookById getBookById;

  @GetMapping("/{idBook}")
  public BookResponse getBookById(
    @PathVariable final Long idBook,
    @RequestParam final String currency
  ) {
    return this.getBookById.execute(new BookQuery(idBook, currency));
  }

}
