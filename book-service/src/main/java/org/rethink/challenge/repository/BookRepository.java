package org.rethink.challenge.repository;

import org.rethink.challenge.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Long> {
}
