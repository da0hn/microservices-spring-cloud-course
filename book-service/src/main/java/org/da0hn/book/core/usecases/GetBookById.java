package org.da0hn.book.core.usecases;

import lombok.AllArgsConstructor;
import org.da0hn.book.core.domain.BookEntity;
import org.da0hn.book.application.BookQuery;
import org.da0hn.book.application.BookResponse;
import org.da0hn.book.core.domain.BookNotFoundException;
import org.da0hn.book.data.db.JpaBookRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetBookById {

  private static final String PORT = "local.server.port";
  private final Environment environment;
  private final JpaBookRepository repository;

  public BookResponse execute(final BookQuery query) {
    final var book = this.fetchBook(query);
    final var port = this.environment.getProperty(PORT);

    final var price = book.getPrice();



    return new BookResponse(
      book.getId(),
      book.getAuthor(),
      book.getLaunchDate(),
      price,
      book.getTitle(),
      query.currency(),
      port
    );
  }


  private BookEntity fetchBook(final BookQuery query) {
    return this.repository.findById(query.idBook())
      .orElseThrow(BookNotFoundException::new);
  }


}
