package org.da0hn.book.data.db;

import org.da0hn.book.core.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBookRepository extends JpaRepository<BookEntity, Long> {
}
