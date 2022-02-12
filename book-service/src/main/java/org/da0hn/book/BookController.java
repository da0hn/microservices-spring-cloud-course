package org.da0hn.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/books")
public class BookController {


  @GetMapping("/{idBook}")
  public BookResponse getBookById(
    @PathVariable final Long idBook,
    @RequestParam final String currency
  ) {
    return new BookResponse(
      idBook,
      "Nigel Poulton",
      LocalDateTime.now(),
      BigDecimal.ONE,
      "Docker Deep Dive",
      currency,
      "8100"
    );
  }

}
