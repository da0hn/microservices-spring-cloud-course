package org.da0hn.book.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "book")
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "author", nullable = false)
  private String author;

  @Column(name = "launch_date", nullable = false)
  private LocalDateTime launchDate;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "price", nullable = false)
  private BigDecimal price;

}
